package com.juvenxu.mvnbook.account.email;

public interface AccountEmailService {

    /**
     *
     * @param to 接受地址
     * @param subject 邮件主题
     * @param htmlText 邮件内容
     * @throws AccountEmailException
     */
    void sendMail(String to,String subject,String htmlText) throws AccountEmailException;
}
