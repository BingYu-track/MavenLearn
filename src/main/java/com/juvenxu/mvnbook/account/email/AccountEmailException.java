package com.juvenxu.mvnbook.account.email; /**
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

/**
 * @Description:
 * @author: hxw
 * @version 1.0
 * @date: 2018/5/25 20:10
 */
public class AccountEmailException extends Exception{

    private static final long serialVersionUID = -4817386460334501672L;

    public AccountEmailException( String message ){
        super(message);
    }

    public AccountEmailException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
