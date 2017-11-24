package com.lxs.mms.user.db.mapper;


import com.lxs.mms.user.db.bean.User;

/**
 * 对应classpath:mapper.UserMapper.xml。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public interface UserMapper {
    int saveUser(User user);
}
