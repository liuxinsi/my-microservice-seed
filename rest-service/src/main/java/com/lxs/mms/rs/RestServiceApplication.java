package com.lxs.mms.rs;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@SpringBootApplication
@ComponentScan(value = "com.lxs.mms")
@MapperScan("com.lxs.mms.db.mapper")
public class RestServiceApplication {


    public static void main(String[] args) {
        SpringApplication.run(RestServiceApplication.class, args);
    }
}
