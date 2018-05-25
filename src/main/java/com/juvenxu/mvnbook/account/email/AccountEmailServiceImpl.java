/**
 * Project: AccountEmail
 * <p>
 * File Created at 2018/5/25
 * <p>
 * Copyright 2018 e-dewin.com Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com.
 */
package com.juvenxu.mvnbook.account.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/5/25 19:43
 */
public class AccountEmailServiceImpl implements AccountEmailService {

    private JavaMailSender javaMailSender;

    private String systemEmail;

    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
        try{
            MimeMessage msg = javaMailSender.createMimeMessage();
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
            msgHelper.setFrom(systemEmail);
            msgHelper.setTo(to);
            msgHelper.setSubject(subject);
            msgHelper.setText(htmlText,true);
            javaMailSender.send(msg);
        }catch(MessagingException e){
            throw new AccountEmailException("Fail to send mail.",e);
        }
    }

    public JavaMailSender getJavaMailSender(){
        return javaMailSender;
    }
}
