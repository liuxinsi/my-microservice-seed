package com.lxs.mms.db.service;

import com.lxs.mms.db.bean.User;
import com.lxs.mms.db.mapper.UserMapper;
import com.lxs.mms.utils.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Service
@Transactional
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public int saveUser(User user) {
        if (user.getStatus() == null) {
            user.setStatus(User.Status.ACTIVE);
        }
        user.setUserId(new ObjectId().toString());
        return userMapper.saveUser(user);
    }
}
