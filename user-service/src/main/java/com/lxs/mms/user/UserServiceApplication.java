package com.lxs.mms.user;

import com.lxs.mms.rest.service.core.jersey.JerseyCoreConfig;
import com.lxs.mms.rest.service.core.swagger.Swagger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@EnableDiscoveryClient
@SpringBootApplication
@ComponentScan(value = "com.lxs.mms")
@MapperScan("com.lxs.mms.user.db.mapper")
public class UserServiceApplication {
    @Bean
    public Swagger registerSwagger() {
        return new Swagger("用户服务",
                "提供用户信息相关的服务",
                "1.0.0");
    }

    @Bean
    public JerseyCoreConfig registerJersey() {
        return new JerseyCoreConfig("com.lxs.mms.user.resource");
    }

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
