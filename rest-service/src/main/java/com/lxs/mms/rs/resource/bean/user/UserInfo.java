package com.lxs.mms.rs.resource.bean.user;

import lombok.Data;

import java.util.Date;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Data
public class UserInfo {
    private String id;
    private String name;
    private String pwd;
    private Date registeDate;
}
