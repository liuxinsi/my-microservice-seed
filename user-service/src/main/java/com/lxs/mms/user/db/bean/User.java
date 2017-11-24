package com.lxs.mms.user.db.bean;

import lombok.Data;

import java.util.Date;

/**
 * 对应数据库TB_USER表。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Data
public class User {
    private String userId;

    private String name;
    private String password;

    private Date birthday;

    private String mail;

    private Status status;


    public enum Status {
        ACTIVE, INVALID
    }
}
