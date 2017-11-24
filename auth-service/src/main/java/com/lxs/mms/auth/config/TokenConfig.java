package com.lxs.mms.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@ConfigurationProperties(prefix = "auth.jwt.token")
@Component
@Data
public class TokenConfig {
    /**
     * 过期时间(秒)
     */
    private Integer expireInSec;
    /**
     * 签发者
     */
    private String issuer;
}
