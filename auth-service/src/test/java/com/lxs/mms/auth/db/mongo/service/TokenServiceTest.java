package com.lxs.mms.auth.db.mongo.service;

import com.lxs.mms.auth.AuthServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthServiceApplication.class)
public class TokenServiceTest {
    @Autowired
    private TokenService tokenService;

    @Test
    public void testSave() {
        tokenService.saveToken("1", "2");
    }
}
