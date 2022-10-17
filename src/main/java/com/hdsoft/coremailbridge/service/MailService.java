package com.hdsoft.coremailbridge.service;

import com.hdsoft.coremailbridge.model.Mail;

public interface MailService {
    Mail findMail(String mid);

    void addMail(Mail mail);

    void updateMail(Mail mail);
}
