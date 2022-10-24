package com.hdsoft.coremailbridge.task;

import com.google.gson.Gson;
import com.hdsoft.coremailbridge.dto.*;
import com.hdsoft.coremailbridge.model.User;
import com.hdsoft.coremailbridge.service.FeiShuService;
import com.hdsoft.coremailbridge.service.UserService;
import com.nimbusds.oauth2.sdk.TokenResponse;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class AccountSyncTask {
    private final Logger logger = LoggerFactory.getLogger(AccountSyncTask.class);

    @Autowired
    private FeiShuService feiShuService;

    @Autowired
    private UserService userService;

    @Value(value = "${feishu.app_id}")
    private String appId;

    @Value(value = "${feishu.app_secret}")
    private String appSecret;


    @Scheduled(cron = "0 0 */2 * * ?")
    public void execute() {
        List<FeiShuDepartment> feishuDepartmentList = new ArrayList<FeiShuDepartment>();
        List<FeiShuUser> feishuUserList = new ArrayList<>();

        TokenResp tokenResponse = feiShuService.getInternalTenantAccessToken(appId, appSecret);
        if (tokenResponse != null && !StringUtils.isEmpty(tokenResponse.getTenant_access_token())) {
            String pageToken = "";
            ContactScopesDto contactScopesDto = null;
            do {
                contactScopesDto = feiShuService.getFeishuContactScopes(tokenResponse.getTenant_access_token(), pageToken);
                logger.info(new Gson().toJson(contactScopesDto));
                if (contactScopesDto != null) {
                    // 组织
                    if (contactScopesDto.getDepartment_ids() != null && contactScopesDto.getDepartment_ids().size() > 0) {
                        for (int i = 0; i < contactScopesDto.getDepartment_ids().size(); i++) {
                            String departId = contactScopesDto.getDepartment_ids().get(i);
                            recursiveGetFeishuDepartments(tokenResponse.getTenant_access_token(), feishuDepartmentList,  null, departId);
                        }
                    }
                    if (contactScopesDto.getUser_ids() != null && contactScopesDto.getUser_ids().size() > 0) {
                        for (int i = 0; i < contactScopesDto.getUser_ids().size(); i++) {
                            String userId = contactScopesDto.getUser_ids().get(i);
                            FeiShuNewUser feiShuNewUser = feiShuService.getFeishuUser(tokenResponse.getTenant_access_token(), userId);
                            if (feiShuNewUser != null) {
                                User dbUser = insertOrUpdateUser(feiShuNewUser.getUser());
//                                if (needAddToDomain) {
//                                    addDomainCommonUser(domainId, dbUser);
//                                }
                            }
                        }
                    }

                    logger.info("sync set pageToken : {}, newPageToken : {}", pageToken, contactScopesDto.getPage_token());
                    pageToken = contactScopesDto.getPage_token();
                }
            }
            while (contactScopesDto != null && contactScopesDto.isHas_more());
        }
    }

    /**
     * 递归获取全部部门
     */
    private List<FeiShuDepartment> recursiveGetFeishuDepartments(String accessToken, List<FeiShuDepartment> feishuDepartmentList, String pageToken, String parentDepartmentId) {
        FeiShuDepatmentList feiShuDepatmentList = feiShuService.getDepartmentList(accessToken, pageToken, parentDepartmentId);
        if(feiShuDepatmentList != null && feiShuDepatmentList.getItems() != null && feiShuDepatmentList.getItems().size() > 0) {
            feishuDepartmentList.addAll(feiShuDepatmentList.getItems());

            // 获取子部门列表 fetch_child=true + parent_department_id=0不生效
            for (Iterator iterator = feiShuDepatmentList.getItems().iterator(); iterator.hasNext();) {
                FeiShuDepartment feiShuDepartment = (FeiShuDepartment) iterator.next();

                List<FeiShuUser> feishuUserList = new ArrayList<FeiShuUser>();
                feishuUserList = recursiveAggregateGetFeishuUser(accessToken, feishuUserList, null, feiShuDepartment.getOpen_department_id());
                if (feishuUserList != null) {
                    for (int i = 0; i < feishuUserList.size(); i++) {
                        User dbUser = insertOrUpdateUser(feishuUserList.get(i));
//                        if (needAddToDomain) {
//                            addDomainCommonUser(domainId, dbUser);
//                        }
                    }
                }


                recursiveGetFeishuDepartments(accessToken, feishuDepartmentList,  null, feiShuDepartment.getOpen_department_id());
            }

        } else {
            logger.info("get feishu department list error");
        }

        if(feiShuDepatmentList.getHas_more()) {
            return recursiveGetFeishuDepartments(accessToken, feishuDepartmentList, feiShuDepatmentList.getPage_token(), parentDepartmentId);
        }
        return feishuDepartmentList;
    }

    public List<FeiShuUser> recursiveAggregateGetFeishuUser(String accessToken, List<FeiShuUser> userList, String page_token, String departmentId) {
//		FeishuGetUserListResponse userListResponse = feiShuService.getFeishuUserList(accessToken, page_token, departmentId);
        FeiShuUserList feiShuUserList = feiShuService.findDepartmentUser(accessToken, departmentId);
        if (feiShuUserList != null && feiShuUserList.getItems() != null && feiShuUserList.getItems().size() > 0) {
            userList.addAll(feiShuUserList.getItems());
        }
//		if(userListResponse.getCode() == 0 && userListResponse.getData() != null && userListResponse.getData().getItems() != null) {
//			userList.addAll(userListResponse.getData().getItems());
//		} else {
//			logger.info("get feishu departmen list error, code:{}, message:{}", userListResponse.getCode(), userListResponse.getMsg());
//		}
//
//		if(userListResponse.getData() != null && userListResponse.getData().getHas_more()) {
//			return this.recursiveAggregateGetFeishuUser(accessToken, userList, userListResponse.getData().getPage_token(), departmentId);
//		}
        return userList;
    }

    public User insertOrUpdateUser(FeiShuUser feishuUser) {
        User dbUser = userService.findUserAccount(feishuUser.getMobile());
        if (dbUser == null) {
            dbUser = new User();
        }
        dbUser = feishuUser2User(dbUser, feishuUser);
        userService.saveUser(dbUser);
        return dbUser;
    }

    private User feishuUser2User(User user, FeiShuUser feishuUser) {
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        user.setMobile(feishuUser.getMobile());
        user.setEmail(feishuUser.getEmail());
        user.setUserName(feishuUser.getMobile());
        user.setDisplayName(feishuUser.getName());
        user.setFsUnionId(feishuUser.getUnion_id());
        user.setStatus(true);
        return user;
    }
}
