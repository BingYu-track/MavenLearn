/**
 * Project: AccountEmail
 * <p>
 * File Created at 2018/5/27
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

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.mail.internet.MimeMessage;
import static junit.framework.Assert.assertEquals;
/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/5/27 14:16
 */
public class AccountEmailServiceTest {

    private GreenMail greenMail;

    @Before //先于测试方法执行
    public void startMailServer() throws Exception{
        greenMail = new GreenMail(ServerSetup.SMTP);
        //创建邮件账户并启动邮件服务
        greenMail.setUser("test@juvenxu.com","123456");
        greenMail.start();
    }

    @Test
    public void testSendMail()throws Exception{
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("account-email.xml");
        AccountEmailService accountEmailService = (AccountEmailService)ctx.getBean("accountEmailService");

        String subject = "Test Subject";
        String htmlText = "<h3>Test</h3>";
        accountEmailService.sendMail("test2@juvenxu.com",subject,htmlText);
        greenMail.waitForIncomingEmail(2000,1);
        MimeMessage[] msgs = greenMail.getReceivedMessages();
        assertEquals(1,msgs.length);
        assertEquals(subject,msgs[0].getSubject());
        assertEquals(htmlText, GreenMailUtil.getBody(msgs[0]).trim());
    }

    @After
    public void stopMailServer() throws Exception{
        greenMail.stop();
    }
}
