package com.hdsoft.coremailbridge.service.impl;

import com.hdsoft.coremailbridge.wsdl.API;
import com.hdsoft.coremailbridge.wsdl.ReturnInfo;

import java.net.MalformedURLException;
import java.net.URLDecoder;

public class CoreMailService {
    API api;
    boolean useWebName = false;

    private String coremailUrl = "http://116.198.25.145:9900";
    private String namespaceUrl = "http://116.198.25.145:9900/apiws";

    public CoreMailService(String apiWsdlUrl) throws Exception {
        this.api = javax.xml.ws.Service.create(
                new java.net.URL(apiWsdlUrl),
                new javax.xml.namespace.QName("http://coremail.cn/apiws", "API")
        ).getPort(API.class);
    }

    /**
     * 获取邮箱用户单点登录链接
     * @param userEmail 用户邮箱地址
     * @param loginAttrs 登录参数，参数说明见docs文档
     * @return 单点登录链接，跳转到该链接即可进入邮箱
     * @throws Exception
     */
    public String userLogin(String userEmail, String loginAttrs) throws Exception {
        ReturnInfo ret = api.userLoginEx(userEmail, loginAttrs);
        if (ret.getCode() == 0) {
            String encodedResult = ret.getResult();
            String sid = getParameter(encodedResult, "sid");
            String webname = getParameter(encodedResult, "webname");
            String mainURL = "";
            if (useWebName) {
                mainURL = webname + "/coremail/main.jsp?sid=" + sid;
            }
            else {
                mainURL = coremailUrl + "/coremail/main.jsp?sid=" + sid;
            }

            return mainURL;
        } else {
            return null;
        }
    }

    /**
     * 从接口返回结果中获取指定部分的值
     * @param encodedResult 接口返回结果
     * @param key 要获取值的key
     * @return 值
     * @throws Exception
     */
    private String getParameter(String encodedResult, String key) throws Exception {
        int start;
        if (encodedResult.startsWith(key + '=')) {
            start = key.length() + 1;
        } else {
            int i = encodedResult.indexOf('&' + key + '=');
            if (i == -1) {
                return null;
            }
            start = i + key.length() + 2;
        }

        int end = encodedResult.indexOf('&', start);
        String value = (end == -1)
                ? encodedResult.substring(start)
                : encodedResult.substring(start, end);

        return URLDecoder.decode(value, "GBK");
    }

    public static void main(String[] args) throws Exception {
        CoreMailService coreMailService = new CoreMailService("http://116.198.25.145:9900/apiws/services/API?wsdl");
        String url = coreMailService.userLogin("feishu@baicgroup.com.cn", "style=1");
        System.out.println(url);
    }
}
