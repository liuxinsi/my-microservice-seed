package com.lxs.mms.rest.service.core.swagger;

import com.lxs.mms.rest.service.core.jersey.JerseyCoreConfig;
import io.swagger.jaxrs.config.BeanConfig;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.PostConstruct;

/**
 * Swagger配置。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Slf4j
@AllArgsConstructor
public class Swagger {
    private String serviceName;
    private String serviceDesc;
    private String serviceVersion;

    @PostConstruct
    public void initSwagger() {
        log.warn("Current env is dev ,enable Swagger");
        BeanConfig config = new BeanConfig();
        config.setTitle(serviceName);
        config.setDescription(serviceDesc);
        config.setVersion(serviceVersion);
        config.setContact("liuxinsi");
        config.setSchemes(new String[]{"http", "https"});
        config.setBasePath(JerseyCoreConfig.DEFAULT_APPLICATION_PATH);
        config.setResourcePackage(JerseyCoreConfig.resourcePackageName);
        config.setPrettyPrint(true);
        config.setScan(true);
    }
}
