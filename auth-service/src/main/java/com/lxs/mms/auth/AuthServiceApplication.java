package com.lxs.mms.auth;

import com.lxs.mms.rest.service.core.jersey.JerseyCoreConfig;
import com.lxs.mms.rest.service.core.swagger.Swagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@SpringBootApplication
@ComponentScan(value = "com.lxs.mms")
public class AuthServiceApplication {

    @Bean
    public Swagger registerSwagger() {
        return new Swagger("认证服务",
                "提供认证与鉴权服务",
                "1.0.0");
    }

    @Bean
    public JerseyCoreConfig registerJersey() {
        return new JerseyCoreConfig("com.lxs.mms.auth.resource");
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthServiceApplication.class, args);
    }
}
