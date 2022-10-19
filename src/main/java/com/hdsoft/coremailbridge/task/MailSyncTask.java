package com.hdsoft.coremailbridge.task;

import com.google.gson.Gson;
import com.hdsoft.coremailbridge.dto.FeiShuMessageRespData;
import com.hdsoft.coremailbridge.dto.MailInfo;
import com.hdsoft.coremailbridge.dto.TokenResp;
import com.hdsoft.coremailbridge.model.Mail;
import com.hdsoft.coremailbridge.model.User;
import com.hdsoft.coremailbridge.service.FeiShuService;
import com.hdsoft.coremailbridge.service.MailService;
import com.hdsoft.coremailbridge.service.UserService;
import com.hdsoft.coremailbridge.service.impl.CoreMailService;
import com.hdsoft.coremailbridge.utils.CrontabConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Component
public class MailSyncTask {

    private final Logger logger = LoggerFactory.getLogger(MailSyncTask.class);

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

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

    @Value(value = "${spring.jmx.default-domain}")
    private String jmxDomain;

    @Value(value = "${coremail.debug}")
    private boolean coreMailDebug;

    @Scheduled(cron = CrontabConst.PER_MINUTE)
    public void execute() {
        logger.info("mail sync task start execute");
        try {
//            if (coreMailDebug) {
//                logger.info("dev env break mail sync task");
//                return;
//            }
            String template = "{\"elements\":[{\"tag\":\"markdown\",\"content\":\"##subject##\\n\\n发件人 :  ##from##\\n时间 : ##date##\",\"href\":{}},{\"tag\":\"action\",\"actions\":[{\"tag\":\"button\",\"text\":{\"tag\":\"plain_text\",\"content\":\"查看详情\"},\"type\":\"primary\",\"url\":\"##detail_url##\"}]}],\"header\":{\"template\":\"blue\",\"title\":{\"content\":\"您有一封新邮件\",\"tag\":\"plain_text\"}}}";

            List<User> userList = userService.listUsers();
            if (userList != null && userList.size() > 0) {
                CoreMailService coreMailService = new CoreMailService(wsdlUrl);
                for (int i = 0; i < userList.size(); i++) {
                    User user = userList.get(i);
                    // 取得未读邮件
                    String mailInfoStr = coreMailService.getNewMailList(user.getEmail(), 10);
                    List<MailInfo> mailInfoList = coreMailService.parseMailFromStr(mailInfoStr);
                    if (mailInfoList != null && mailInfoList.size() > 0) {
                        for (int j = 0; j < mailInfoList.size(); j++) {
                            MailInfo mailInfo = mailInfoList.get(j);
                            Mail mail = mailService.findMail(mailInfo.getMid());
                            if (mail == null) {
                                mail = new Mail();
                                mail.setMid(mailInfo.getMid());
                                mail.setMsid(mailInfo.getMsid());
                                mail.setFid(mailInfo.getFid());
                                mail.setFlag(mailInfo.getFlag());
                                mail.setMailFrom(replaceTemplate(mailInfo.getFrom()));
                                mail.setMailTo(replaceTemplate(mailInfo.getTo()));
                                mail.setSubject(replaceTemplate(mailInfo.getSubject()));
                                mail.setSize(mailInfo.getSize());
                                mail.setDate(mailInfo.getDate());
                                mail.setCreateTime(new Date());
                                mail.setUpdateTime(new Date());
                                mailService.addMail(mail);
                            }

                            if (mail.getPushed() != null && mail.getPushed() == true) {
                                logger.info("mail pushed before, break push. mid : {}", mail.getMid());
                            }
                            else {
                                TokenResp tokenResp = feiShuService.getInternalTenantAccessToken(appId, appSecret);
                                String copyTemplate = template;
                                logger.info("mailInfo : {}", new Gson().toJson(mailInfo));
                                copyTemplate = copyTemplate.replaceAll("##subject##", replaceTemplate(mailInfo.getSubject()));
                                copyTemplate = copyTemplate.replaceAll("##from##", replaceTemplate(mailInfo.getFrom()));
                                copyTemplate = copyTemplate.replaceAll("##date##", replaceTemplate(mailInfo.getDate()));
                                String appLink = "https://applink.feishu.cn/client/web_app/open?appId=" + appId + "&path=" + jmxDomain + "/mainPage?mid=" + mailInfo.getMid() + "&mode=window";
//                                String appLink = serverDomain + "/mainPage?fromMsg=T";
                                copyTemplate = copyTemplate.replaceAll("##detail_url##", appLink);
                                logger.info("copyTemplate : {}", copyTemplate);
                                FeiShuMessageRespData feiShuMessageRespData = feiShuService.sendMessages(tokenResp.getTenant_access_token(), copyTemplate, user.getFsUnionId());
                                if (feiShuMessageRespData != null) {
                                    String feiShuMsgId = feiShuMessageRespData.getMessage_id();
                                    mail.setPushed(true);
                                    mail.setPushedTime(new Date());
                                    mail.setReceriverId(user.getFsUnionId());
                                    mail.setMsgId(feiShuMsgId);
                                    mailService.updateMail(mail);
                                }
                            }

                        }
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

    private String replaceTemplate(String value) throws Exception{
        Pattern pattern = Pattern.compile("\n|\t|\r");
        value = pattern.matcher(value).replaceAll("");

        value = value.replaceAll("\\u003c", "<<");
        value = value.replaceAll("\\u003e", ">>");

        if (value.contains("\"")) {
            value = value.replaceAll("\"", "“");
            logger.info("replaced string quotes : {}", value);
        }

        return value;
    }
}
