package com.hdsoft.coremailbridge.service.impl;

import com.google.gson.Gson;
import com.hdsoft.coremailbridge.dto.*;
import com.hdsoft.coremailbridge.exception.RestTemplateResponseErrorHandler;
import com.hdsoft.coremailbridge.service.FeiShuService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class FeiShuServiceImpl implements FeiShuService {

    private final Logger logger = LoggerFactory.getLogger(FeiShuServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public TokenResp getInternalTenantAccessToken(String appId, String appSecret) {
        logger.info("FeiShu get internal tenant accessToken, appId : {}, app_secret : {}", appId, appSecret);

        String targetUrl = "https://open.feishu.cn/open-apis/auth/v3/tenant_access_token/internal/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("app_id", appId);
        reqMap.put("app_secret", appSecret);

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap,headers);
        logger.info("FeiShu get internal tenant accessToken, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        ResponseEntity<TokenResp> resp = restTemplate.exchange(targetUrl, HttpMethod.POST, entity, TokenResp.class);
        logger.info("FeiShu get internal tenant accessToken, responseBody : {}", new Gson().toJson(resp.getBody()));

        return resp.getBody();
    }

    /**
     * 获取登录用户信息
     * @param code
     * @param appAccessToken
     * @return
     */
    @Override
    public FeishuGetLoginUserData getLoginUserInfo(String code, String appAccessToken) {
        logger.info("FeiShu get login user info, code : {}, appAccessToken : {}", code, appAccessToken);
        String targetUrl = "https://open.feishu.cn/open-apis/authen/v1/access_token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + appAccessToken);
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("code", code);
        reqMap.put("grant_type", "authorization_code");

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
        logger.info("FeiShu get login user info, targetUrl : {}, entity : {}", targetUrl,new Gson().toJson(entity));
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        ResponseEntity<FeiShuResponse<FeishuGetLoginUserData>> resp = restTemplate.exchange(targetUrl, HttpMethod.POST, entity, new ParameterizedTypeReference<FeiShuResponse<FeishuGetLoginUserData>>() {});
        logger.info("FeiShu get login user info, responseBody : {}", new Gson().toJson(resp.getBody()));
        if(!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
            logger.error("FeiShu get login user info error,{}", resp.getStatusCode());
            return null;
        }
        return resp.getBody().getData();
    }

    @Override
    public FeiShuMessageRespData sendMessages(String appAccessToken, String content, String receiverId) {
        logger.info("feishu send message, appAccessToken : {}, receiverId : {}, msgContent : {}", appAccessToken, receiverId, content);
        if (StringUtils.isEmpty(receiverId)) {
            logger.error("feishu send message, receiverId is empty. msgContent : {}", content);
            return null;
        }

        String targetUrl = "https://open.feishu.cn/open-apis/im/v1/messages?receive_id_type=union_id";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + appAccessToken);

        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("msg_type", "interactive");
        reqMap.put("receive_id", receiverId);
        reqMap.put("content", content);

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
        logger.info("feishu send message, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        ResponseEntity<FeiShuResponse<FeiShuMessageRespData>> resp = restTemplate.exchange(targetUrl, HttpMethod.POST, entity, new ParameterizedTypeReference<FeiShuResponse<FeiShuMessageRespData>>() {});
        logger.info("feishu send message, responseBody : {}", new Gson().toJson(resp.getBody()));
        if (resp.getBody().getCode() == 0) {
            return resp.getBody().getData();
        }

        return null;
    }

    /**
     * 获取通讯录授权范围
     */
    @Override
    public ContactScopesDto getFeishuContactScopes(String appAccessToken, String page_token) {
        logger.info("FeiShu get contact scopes, appAccessToken : {}, page_token:{}", appAccessToken, page_token);

        String targetUrl = "https://open.feishu.cn/open-apis/contact/v3/scopes?user_id_type=union_id&department_id_type=open_department_id";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + appAccessToken);
        Map<String, Object> reqMap = new HashMap<String, Object>();
//        reqMap.put("user_id_type", "union_id");
//        reqMap.put("department_id_type", "open_department_id");
//        reqMap.put("page_size", 50);

        if (!StringUtils.isEmpty(page_token)) {
            reqMap.put("page_token", page_token);
            targetUrl += "&page_token=" + page_token;
        }

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
        logger.info("FeiShu get contact scopes, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));
        ResponseEntity<FeiShuResponse<ContactScopesDto>> resp = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<FeiShuResponse<ContactScopesDto>>() {});
        logger.info("FeiShu get contact scopes, responseBody : {}", new Gson().toJson(resp.getBody()));
        if(!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
            logger.error("FeiShu contact scopes error, code:{}, message: {}", resp.getStatusCode());
            return null;
        }
        logger.info("FeiShu contact scopes list:{}", new Gson().toJson(resp.getBody()));
        return resp.getBody().getData();
    }

    /**
     * 获取用户信息
     */
    @Override
    public FeiShuNewUser getFeishuUser(String appAccessToken, String user_id) {
        logger.info("FeiShu get user, appAccessToken : {}, user_id:{}", appAccessToken, user_id);

        String targetUrl = "https://open.feishu.cn/open-apis/contact/v3/users/" + user_id + "?user_id_type=union_id&department_id_type=open_department_id";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + appAccessToken);
        Map<String, Object> reqMap = new HashMap<String, Object>();
//        reqMap.put("user_id_type", "union_id");
//        reqMap.put("department_id_type", "open_department_id");

        try{
            HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
            logger.info("FeiShu get user, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));
            ResponseEntity<FeiShuResponse<FeiShuNewUser>> resp = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<FeiShuResponse<FeiShuNewUser>>() {});
            logger.info("FeiShu get user, responseBody : {}", new Gson().toJson(resp.getBody()));
            if(!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
                logger.error("FeiShu contact scopes error, code:{}, message: {}", resp.getStatusCode());
                return null;
            }
            logger.info("FeiShu get user :{}", new Gson().toJson(resp.getBody()));
            return resp.getBody().getData();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
        return null;
    }

    /**
     * 获取飞书部门列表
     */
    @Override
    public FeishuGetDepartmentListResponse getFeishuDepartmentList(String appAccessToken, String page_token, String parent_department_id) {
        logger.info("FeiShu get department list, appAccessToken : {}, page_token:{}, parent_department_id : {}", appAccessToken, page_token, parent_department_id);

        String targetUrl = "https://open.feishu.cn/open-apis/contact/v3/departments";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + appAccessToken);
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("user_id_type", "union_id");
        reqMap.put("department_id_type", "open_department_id");
        reqMap.put("fetch_child", true);
        reqMap.put("page_size", 50);

        if (!StringUtils.isEmpty(page_token)) {
            reqMap.put("page_token", page_token);
        }

        if (!StringUtils.isEmpty(parent_department_id)) {
            reqMap.put("parent_department_id", parent_department_id);
        }

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
        logger.info("FeiShu get department list, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));
        ResponseEntity<FeishuGetDepartmentListResponse> resp = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, FeishuGetDepartmentListResponse.class);
        logger.info("FeiShu get department list, responseBody : {}", new Gson().toJson(resp.getBody()));
        if(!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
            logger.error("FeiShu department list error, code:{}, message: {}", resp.getStatusCode());
            return null;
        }
        logger.info("FeiShu get department list:{}", new Gson().toJson(resp.getBody()));
        return resp.getBody();
    }

    /**
     * 获取飞书部门列表
     */
    @Override
    public FeiShuDepatmentList getDepartmentList(String accessToken, String pageToken, String parentDepartmentId) {
        logger.info("FeiShu get department list, appAccessToken : {}, page_token:{}, parent_department_id : {}", accessToken, pageToken, parentDepartmentId);

        String targetUrl = "https://open.feishu.cn/open-apis/contact/v3/departments/" + parentDepartmentId + "/children";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + accessToken);
        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("user_id_type", "open_id");
        reqMap.put("department_id_type", "open_department_id");
        reqMap.put("fetch_child", true);
        reqMap.put("page_size", 50);

        if (!StringUtils.isEmpty(pageToken)) {
            reqMap.put("page_token", pageToken);
        }

        if (!StringUtils.isEmpty(parentDepartmentId)) {
            reqMap.put("parent_department_id", parentDepartmentId);
        }

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
        logger.info("FeiShu get department list, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));
        ResponseEntity<FeiShuResponse<FeiShuDepatmentList>> resp = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<FeiShuResponse<FeiShuDepatmentList>>() {});
        logger.info("FeiShu get department list, responseBody : {}", new Gson().toJson(resp.getBody()));
        if(!resp.getStatusCode().is2xxSuccessful() || resp.getBody() == null) {
            logger.error("FeiShu department list error, code:{}, message: {}", resp.getStatusCode());
            return null;
        }
        logger.info("FeiShu get department list:{}", new Gson().toJson(resp.getBody()));
        return resp.getBody().getData();
    }

    @Override
    public FeiShuUserList findDepartmentUser(String accessToken, String departmentId) {
        logger.info("FeiShu find department user, accessToken : {}, departmentId : {}", accessToken, departmentId);

        String targetUrl = "https://open.feishu.cn/open-apis/contact/v3/users/find_by_department?user_id_type=open_id&department_id_type=open_department_id&page_size=50&department_id=" + departmentId;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.add("Authorization", "Bearer " + accessToken);

        Map<String, Object> reqMap = new HashMap<String, Object>();
        reqMap.put("user_id_type", "open_id");
        reqMap.put("department_id_type", "open_department_id");
        reqMap.put("department_id", departmentId);
        reqMap.put("page_size", 50);

        HttpEntity<Object> entity = new HttpEntity<Object>(reqMap, headers);
        logger.info("FeiShu find department user, targetUrl : {}, entity : {}", targetUrl, new Gson().toJson(entity));

        ResponseEntity<FeiShuResponse<FeiShuUserList>> resp = restTemplate.exchange(targetUrl, HttpMethod.GET, entity, new ParameterizedTypeReference<FeiShuResponse<FeiShuUserList>>() {});
        logger.info("FeiShu find department user, responseBody : {}", new Gson().toJson(resp.getBody()));
        return resp.getBody().getData();
    }
}
