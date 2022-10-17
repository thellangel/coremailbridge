package com.hdsoft.coremailbridge.service.impl;

import com.hdsoft.coremailbridge.model.Mail;
import com.hdsoft.coremailbridge.model.MailExample;
import com.hdsoft.coremailbridge.persistence.MailMapper;
import com.hdsoft.coremailbridge.service.MailService;
import com.hdsoft.coremailbridge.task.MailSyncTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    private final Logger logger = LoggerFactory.getLogger(MailServiceImpl.class);

    @Autowired
    private MailMapper mailMapper;

    @Override
    public Mail findMail(String mid) {
        MailExample example = new MailExample();
        example.createCriteria().andMidEqualTo(mid);
        List<Mail> mailList = mailMapper.selectByExampleWithBLOBs(example);
        if (mailList != null && mailList.size() > 0) {
            return mailList.get(0);
        }
        return null;
    }

    @Transactional
    @Override
    public void addMail(Mail mail) {
        mailMapper.insert(mail);
    }

    @Transactional
    @Override
    public void updateMail(Mail mail) {
        mailMapper.updateByPrimaryKeyWithBLOBs(mail);
    }
}
