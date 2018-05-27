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

    private JavaMailSender javaMailSender; //邮件发送工具类

    private String systemEmail;

    public void sendMail(String to, String subject, String htmlText) throws AccountEmailException {
        try{
            MimeMessage msg = javaMailSender.createMimeMessage(); //创建
            MimeMessageHelper msgHelper = new MimeMessageHelper(msg);
            msgHelper.setFrom(systemEmail); //设置邮件发送地址
            msgHelper.setTo(to);    //收件地址
            msgHelper.setSubject(subject); //主题
            msgHelper.setText(htmlText,true); //内容
            javaMailSender.send(msg);
        }catch(MessagingException e){
            throw new AccountEmailException("Fail to send mail.",e);
        }
    }

    public JavaMailSender getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSystemEmail() {
        return systemEmail;
    }

    public void setSystemEmail(String systemEmail) {
        this.systemEmail = systemEmail;
    }
}
