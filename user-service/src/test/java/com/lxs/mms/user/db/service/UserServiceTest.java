package com.lxs.mms.user.db.service;

import com.lxs.mms.user.UserServiceApplication;
import com.lxs.mms.user.db.bean.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserServiceApplication.class)
public class UserServiceTest {
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
