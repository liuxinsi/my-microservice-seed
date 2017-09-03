package com.lxs.mms.db.service;

import com.lxs.mms.db.bean.User;
import com.lxs.mms.rs.RestServiceApplicationTests;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Date;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
public class UserServiceTest extends RestServiceApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void testSaveUser() {
        User u = new User();
        u.setBirthday(new Date());
        u.setMail("alks@mail.com");
        u.setName("测试1");
        u.setPassword("pw");

        int i = userService.saveUser(u);
        Assert.assertEquals(1, i);
    }
}
