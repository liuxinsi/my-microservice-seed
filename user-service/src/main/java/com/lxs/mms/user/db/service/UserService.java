package com.lxs.mms.user.db.service;

import com.lxs.mms.user.db.bean.User;
import com.lxs.mms.user.db.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int saveUser(User user) {
        if (user.getStatus() == null) {
            user.setStatus(User.Status.ACTIVE);
        }
        return userMapper.saveUser(user);
    }
}
