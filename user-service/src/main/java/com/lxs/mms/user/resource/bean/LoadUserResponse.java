package com.lxs.mms.user.resource.bean;

import lombok.Data;

import java.util.Date;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Data
public class LoadUserResponse {
    private String id;
    private String name;
    private String pwd;
    private Date registeDate;
}
