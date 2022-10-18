package com.hdsoft.coremailbridge.service.impl;

import com.google.gson.Gson;
import com.hdsoft.coremailbridge.dto.MailInfo;
import com.hdsoft.coremailbridge.wsdl.API;
import com.hdsoft.coremailbridge.wsdl.ReturnInfo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

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
    public String userLogin(String userEmail, String loginAttrs, boolean mobile) throws Exception {
        ReturnInfo ret = api.userLoginEx(userEmail, loginAttrs);
        if (ret.getCode() == 0) {
            String encodedResult = ret.getResult();
            String sid = getParameter(encodedResult, "sid");
            String webname = getParameter(encodedResult, "webname");
            String mainURL = "";
            if (useWebName) {
                if (mobile) {
                    mainURL = webname + "/coremail/xphone/main.jsp?sid=" + sid;
                }
                else {
                    mainURL = webname + "/coremail/main.jsp?sid=" + sid + "#mail.list";
                }
            }
            else {
                if (mobile) {
                    mainURL = coremailUrl + "/coremail/xphone/main.jsp?sid=" + sid;
                }
                else {
                    mainURL = coremailUrl + "/coremail/main.jsp?sid=" + sid+ "#mail.list";
                }
            }

            return mainURL;
        } else {
            return null;
        }
    }

    /**
     * 获取用户未读邮件列表
     * @param userEmail 用户邮件地址
     * @param limit 数量上限
     * @return 用户未读邮件列表，XML字符串，eg:
     *      <root><mail><mid>...</mid><msid>1</msid><fid>1</fid><flag>26</flag><from>..</from><to>..</to><subject>..</subject><size>2048</size><date>2009-03-19 10:52:36</date></mail></root>
     * @throws Exception
     */
    public String getNewMailList(String userEmail, int limit) throws Exception {
        String options = "format=xml&limit=" + limit;
        ReturnInfo ret = api.getNewMailInfos(userEmail, options);
        if (ret.getCode() == 0) {
            return ret.getResult();
        }
        return null;
    }

    public List<MailInfo> parseMailFromStr(String mailInfo) throws Exception {
        List<MailInfo> mailInfoList = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource();
        is.setCharacterStream(new StringReader(mailInfo));
        Document document = builder.parse(is);
        NodeList nodeList = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element elem = (Element) node;

                // Get the value of the ID attribute.
                String mid = elem.getElementsByTagName("mid")
                        .item(0).getChildNodes().item(0).getNodeValue();
                // Get the value of all sub-elements.
                String msid = elem.getElementsByTagName("msid")
                        .item(0).getChildNodes().item(0).getNodeValue();
                String fid = elem.getElementsByTagName("fid").item(0)
                        .getChildNodes().item(0).getNodeValue();
                String flag = elem.getElementsByTagName("flag").item(0)
                        .getChildNodes().item(0).getNodeValue();
                String from = elem.getElementsByTagName("from").item(0)
                        .getChildNodes().item(0).getNodeValue();
                String to = elem.getElementsByTagName("to").item(0)
                        .getChildNodes().item(0).getNodeValue();

                String subject = elem.getElementsByTagName("subject").item(0)
                        .getChildNodes().item(0).getNodeValue();
                String size = elem.getElementsByTagName("size").item(0)
                        .getChildNodes().item(0).getNodeValue();
                String date = elem.getElementsByTagName("date").item(0)
                        .getChildNodes().item(0).getNodeValue();
                mailInfoList.add(new MailInfo(mid, msid, fid, flag, from, to, subject, size, date));

            }
        }

        return mailInfoList;
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
        String gbkStr = URLDecoder.decode(value, "GBK");
        return new String(gbkStr.getBytes("GBK"), "UTF-8");
    }

//    public static void main(String[] args) throws Exception {
//        CoreMailService coreMailService = new CoreMailService("http://116.198.25.145:9900/apiws/services/API?wsdl");
//        String url = coreMailService.userLogin("feishu@baicgroup.com.cn", "style=1");
//        String mailList = coreMailService.getNewMailList("feishu@baicgroup.com.cn", 10);
////        String mailContent = "<root><mail><mid>1tbiAQAPBmHhHTcACwAEst</mid><msid>1</msid><fid>1</fid><flag>24</flag><from>\"飞书账号对接\" &lt;feishu@baicgroup.com.cn&gt;</from><to>\"飞书账号对接\" &lt;feishu@baicgroup.com.cn&gt;</to><subject>测试</subject><size>1312</size><date>2022-10-14 13:11:43</date></mail></root>";
//        List<MailInfo> mailInfoList = coreMailService.parseMailFromStr(mailList);
//        System.out.println(new Gson().toJson(mailInfoList));
//    }
}
