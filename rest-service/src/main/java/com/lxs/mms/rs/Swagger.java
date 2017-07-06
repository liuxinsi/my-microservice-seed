package com.lxs.mms.rs;

import com.lxs.mms.rs.resource.JerseyConfig;
import io.swagger.jaxrs.config.BeanConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Swagger配置。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Profile("dev")
@Component
@Log4j2
public class Swagger {

    @PostConstruct
    public void initSwagger() {
        log.warn("Current env is dev ,enable Swagger");
        BeanConfig config = new BeanConfig();
        config.setTitle("MMS");
        config.setDescription("my microservice seed");
        config.setVersion("1.0.0");
        config.setContact("liuxinsi");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath(JerseyConfig.APPLICATION_PATH);
        config.setResourcePackage(JerseyConfig.RESOURCE_PACKAGE_NAME);
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}
