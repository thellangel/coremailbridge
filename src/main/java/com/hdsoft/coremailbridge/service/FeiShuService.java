package com.hdsoft.coremailbridge.service;

import com.hdsoft.coremailbridge.dto.FeiShuMessageRespData;
import com.hdsoft.coremailbridge.dto.FeishuGetLoginUserData;
import com.hdsoft.coremailbridge.dto.TokenResp;

public interface FeiShuService {
    TokenResp getInternalTenantAccessToken(String appId, String appSecret);
    FeishuGetLoginUserData getLoginUserInfo(String code, String appAccessToken);
    FeiShuMessageRespData sendMessages(String appAccessToken, String content, String receiverId);
}
