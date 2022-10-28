package com.hdsoft.coremailbridge.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.Date;
import java.util.Formatter;
import java.util.Random;

import com.alipay.api.domain.DataEntry;
import com.google.gson.Gson;
import com.hdsoft.coremailbridge.dto.FeishuGetLoginUserData;
import com.hdsoft.coremailbridge.dto.JsTicket;
import com.hdsoft.coremailbridge.dto.SessionUser;
import com.hdsoft.coremailbridge.dto.TokenResp;
import com.hdsoft.coremailbridge.service.FeiShuService;
import com.hdsoft.coremailbridge.service.impl.CoreMailService;
import com.hdsoft.coremailbridge.utils.WebUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private FeiShuService feiShuService;

    @Value(value = "${feishu.app_id}")
    private String appId;

    @Value(value = "${feishu.app_secret}")
    private String appSecret;

    @Value(value = "${coremail.wdsl.url}")
    private String wsdlUrl;

    @Value(value = "${handian.server.basepath}")
    private String serverDomain;

    @Value(value = "${coremail.debug}")
    private boolean coreMailDebug;

    @RequestMapping(value = { "/mailDetail/{mid}" }, method = RequestMethod.GET)
    public String mailDetail(Model model, HttpSession redisSession, @RequestHeader(value="User-Agent", defaultValue="") String userAgent, @PathVariable(name = "mid") String mid) {
        logger.info("mail detail page invoke, mid : {}, userAgent : {}", mid, userAgent);
        try {
            logger.info("project main page invoke, serverDomain : {}, userAgent : {}", serverDomain, userAgent);

            boolean mobileAgent = isMobileAgent(userAgent);
            SessionUser sessionUser = (SessionUser) redisSession.getAttribute("current_user");
            // 未登录，跳转至SSO登录
            if (sessionUser == null) {
                logger.info("session is empty, redirect to feishu sso page");
                String redirectUrl = serverDomain + "/redirect";
                model.addAttribute("redirectUrl", redirectUrl);
                model.addAttribute("ssoType", "feishu_sso");
                model.addAttribute("appId", appId);
                model.addAttribute("fromMsg", "T");
                model.addAttribute("mobile", mobileAgent ? "T": "F");
                logger.info("redirect to feishu sso, appId : {}, redirectUrl : {}", appId, redirectUrl);
                return "sso_redirect";
            }
            // 直接跳转coremail SSO
            else {
                return "redirect:mainPage";
//                CoreMailService coreMailService = new CoreMailService(wsdlUrl);
//                // coremail的单点地址
//                String targetUrl = coreMailService.userLogin(sessionUser.getEmail(), "style=1", isMobileAgent(userAgent));
//                model.addAttribute("targetUrl", targetUrl);
//                model.addAttribute("ssoType", "coremail_sso");
//                model.addAttribute("fromMsg", "T");
//                model.addAttribute("mobile", mobileAgent ? "T": "F");
//
//
//                String jsApiTicket = genJsTicket();
//                String nonceStr = getRandomString(16);
//                long timestamp = new Date().getTime() * 1000;
//                String url = serverDomain + "/mainPage";
//                String signature = sign(jsApiTicket, nonceStr, timestamp, url);
//
//                model.addAttribute("appId", appId);
//                model.addAttribute("timestamp", String.valueOf(timestamp));
//                model.addAttribute("nonceStr", nonceStr);
//                model.addAttribute("signature", signature);
//
//                logger.info("redirect to coremail sso, appId : {}, redirectUrl : {}, signature : {}, nonceStr : {}, timestamp : {}", appId, targetUrl, signature, nonceStr, timestamp);
//                return "sso_redirect";
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return "errorPage";
    }

    @RequestMapping(value = { "/mainPage" }, method = RequestMethod.GET)
    public String welcomePage(Model model, HttpSession redisSession, @RequestHeader(value="User-Agent", defaultValue="") String userAgent, @RequestParam(name = "fromMsg", required = false, defaultValue = "F") String fromMsg) {
        try {
            logger.info("project main page invoke, serverDomain : {}, userAgent : {}", serverDomain, userAgent);

            boolean mobileAgent = isMobileAgent(userAgent);
            SessionUser sessionUser = (SessionUser) redisSession.getAttribute("current_user");
            // 未登录，跳转至SSO登录
            if (sessionUser == null) {
                logger.info("session is empty, redirect to feishu sso page");
                String redirectUrl = serverDomain + "/redirect";
                model.addAttribute("redirectUrl", redirectUrl);
                model.addAttribute("ssoType", "feishu_sso");
                model.addAttribute("appId", appId);
                model.addAttribute("fromMsg", fromMsg);
                model.addAttribute("mobile", mobileAgent ? "T": "F");
                logger.info("redirect to feishu sso, appId : {}, redirectUrl : {}", appId, redirectUrl);
                return "sso_redirect";
            }
            // 直接跳转coremail SSO
            else {
                CoreMailService coreMailService = new CoreMailService(wsdlUrl);
                // coremail的单点地址
                String targetUrl = coreMailService.userLogin(sessionUser.getEmail(), "style=1", isMobileAgent(userAgent));
                model.addAttribute("targetUrl", targetUrl);
                model.addAttribute("ssoType", "coremail_sso");
                model.addAttribute("fromMsg", fromMsg);
                model.addAttribute("mobile", mobileAgent ? "T": "F");

                String jsApiTicket = genJsTicket();
                String nonceStr = "a" + getRandomString(15);
                long timestamp = new Date().getTime() * 1000;
                String url = serverDomain + "/mainPage";
                String signature = sign(jsApiTicket, nonceStr, timestamp, url);

                model.addAttribute("appId", appId);
                model.addAttribute("timestamp", String.valueOf(timestamp));
                model.addAttribute("nonceStr", nonceStr);
                model.addAttribute("signature", signature);

                logger.info("redirect to coremail sso, appId : {}, redirectUrl : {}, signature : {}, nonceStr : {}, timestamp : {}", appId, targetUrl, signature, nonceStr, timestamp);
                return "sso_redirect";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            logger.error(e.getMessage(), e);
        }

        return "errorPage";
    }

    /**
     * 处理飞书SSO回调
     * @param model
     * @param code
     * @param state
     * @return
     */
    @RequestMapping(value = { "/redirect" }, method = RequestMethod.GET)
    public String feiShuRedirect(Model model, HttpSession redisSession, @RequestHeader(value="User-Agent", defaultValue="") String userAgent,
                                 @RequestParam(name = "code", required = true) String code,
                                 @RequestParam(name = "state", required = false) String state) {
        try {
            logger.info("feishu sso redirect page invoke, code : {}, state : {}", code , state);

            boolean mobileAgent = isMobileAgent(userAgent);
            TokenResp tokenResp = feiShuService.getInternalTenantAccessToken(appId, appSecret);
            // 获取飞书登录用户
            FeishuGetLoginUserData feiShuLoginUserData = feiShuService.getLoginUserInfo(code, tokenResp.getTenant_access_token());
            if (feiShuLoginUserData != null) {
                logger.info("login user : {}", new Gson().toJson(feiShuLoginUserData));
                String email = "";
                if (coreMailDebug) {
                    email = "feishu@baicgroup.com.cn";
                }
                else {
                    email = feiShuLoginUserData.getEmail();
                }

                if (StringUtils.isEmpty(email)) {
                    logger.error("feishu user not set email.");
                    return "errorPage";
                }

                String mobile = feiShuLoginUserData.getMobile();

                SessionUser sessionUser = new SessionUser();
                sessionUser.setEmail(email);
                sessionUser.setMobile(mobile);
                redisSession.setAttribute("current_user", sessionUser);
                logger.info("login user email : {}", email);
//                logger.info("login user mobile : {}", mobile);
//                CoreMailService coreMailService = new CoreMailService(wsdlUrl);
//                // coremail的单点地址
//                String targetUrl = coreMailService.userLogin(email, "style=1", mobileAgent);
//
//                model.addAttribute("targetUrl", targetUrl);
//                model.addAttribute("ssoType", "coremail_sso");
//                model.addAttribute("fromMsg", state);
//
//                model.addAttribute("mobile", mobileAgent ? "T": "F");
//
//                String jsApiTicket = genJsTicket();
//                String nonceStr = "123456";
//                long timestamp = new Date().getTime();
//                String url = serverDomain + "/mainPage";
//                String signature = sign(jsApiTicket, nonceStr, timestamp, url);
//
//                model.addAttribute("appId", appId);
//                model.addAttribute("timestamp", timestamp);
//                model.addAttribute("nonceStr", nonceStr);
//                model.addAttribute("signature", signature);
//
//                logger.info("redirect to coremail sso, appId : {}, redirectUrl : {}, signature : {}, nonceStr : {}, timestamp : {}", appId, targetUrl, signature, nonceStr, timestamp);
                return "redirect:mainPage";
            }
            else {
                logger.error("get FeiShu login user info error.");
                return "errorPage";
            }

        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        return "errorPage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        model.addAttribute("title", "admin");
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userInfo", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // (1) (en)
        // After user login successfully.
        // (vi)
        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);

        return "userInfoPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtils.toString(loginedUser);

            model.addAttribute("userInfo", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }
        return "403Page";
    }

    private boolean isMobileAgent(String userAgent) {
        if(userAgent.toLowerCase().indexOf("android") >= 0) {
            return true;
        }
        if(userAgent.toLowerCase().indexOf("iphone") >= 0 || userAgent.toLowerCase().indexOf("ipad") >= 0) {
            return true;
        }
        return false;
    }

    private String judgeRedirect(String userAgent, String redirectPage) {
        if(userAgent.toLowerCase().indexOf("android") >= 0) {
            // 在微信框架下
            if(userAgent.toLowerCase().indexOf("micromessenger") >= 0) {
                logger.warn("current page is under micromessenger framework.");
            }
            redirectPage = "mobile/" + redirectPage;
            logger.info("use mobile page. page : {}", redirectPage);
            return redirectPage;
        }
        if(userAgent.toLowerCase().indexOf("iphone") >= 0 || userAgent.toLowerCase().indexOf("ipad") >= 0) {
            // 在微信框架下
            if(userAgent.toLowerCase().indexOf("micromessenger") >= 0) {
                logger.warn("current page is under micromessenger framework.");
            }
            redirectPage = redirectPage + "_mobile";
            logger.info("use mobile page. page : {}", redirectPage);
            return redirectPage;
        }
        return redirectPage;
    }


    private String genJsTicket() {
        TokenResp tokenResp = feiShuService.getInternalTenantAccessToken(appId, appSecret);
        if (tokenResp != null) {
            JsTicket jsTicket = feiShuService.getJsTicket(tokenResp.getTenant_access_token());
            return jsTicket.getTicket();
        }
        return null;
    }

    public String sign(String ticket, String noncestr, long timestamp, String url) throws Exception {
        String plain = "jsapi_ticket=" + ticket + "&noncestr=" + noncestr + "&timestamp=" + String.valueOf(timestamp) + "&url=" + url;
        logger.info("plain : {}", plain);
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.reset();
            sha1.update(plain.getBytes("utf-8"));
            return bytesToHex(sha1.digest());

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    //将bytes类型的数据转化为16进制类型
    private static String bytesToHex(byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }

        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static String getRandomString(int length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

//    public static void main(String[] args) {
//        String verifyStr = "jsapi_ticket=617bf955832a4d4d80d9d8d85917a427&noncestr=Y7a8KkqX041bsSwT&timestamp=1510045655000&url=https://m.haiwainet.cn/ttc/3541093/2018/0509/content_31312407_1.html";
//        // 2ee6a79c182eeec8d76e7474136edb6e617b8d58
//        try {
//            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
//            sha1.reset();
//            sha1.update(verifyStr.getBytes("utf-8"));
//            System.out.println(bytesToHex(sha1.digest()));
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
