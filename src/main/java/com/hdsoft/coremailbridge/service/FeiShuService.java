package com.hdsoft.coremailbridge.service;

import com.hdsoft.coremailbridge.dto.*;

public interface FeiShuService {
    TokenResp getInternalTenantAccessToken(String appId, String appSecret);
    FeishuGetLoginUserData getLoginUserInfo(String code, String appAccessToken);
    FeiShuMessageRespData sendMessages(String appAccessToken, String content, String receiverId);

    ContactScopesDto getFeishuContactScopes(String tenantAccessToken, String pageToken);

    FeiShuNewUser getFeishuUser(String appAccessToken, String user_id);

    FeishuGetDepartmentListResponse getFeishuDepartmentList(String appAccessToken, String page_token, String parent_department_id);

    FeiShuDepatmentList getDepartmentList(String accessToken, String pageToken, String parentDepartmentId);

    FeiShuUserList findDepartmentUser(String accessToken, String departmentId);

    JsTicket getJsTicket(String tenantAccessToken);
}
