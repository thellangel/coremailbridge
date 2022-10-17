package com.hdsoft.coremailbridge.service.impl;

import com.google.gson.Gson;
import com.hdsoft.coremailbridge.dto.FeiShuMessageRespData;
import com.hdsoft.coremailbridge.dto.FeiShuResponse;
import com.hdsoft.coremailbridge.dto.FeishuGetLoginUserData;
import com.hdsoft.coremailbridge.dto.TokenResp;
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
}
