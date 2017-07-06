package com.lxs.mms.rs.resource;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import lombok.extern.log4j.Log4j2;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * jersey 相关配置。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Component
@ApplicationPath(JerseyConfig.APPLICATION_PATH)
@Log4j2
public class JerseyConfig extends ResourceConfig {
    public static final String APPLICATION_PATH = "services";
    public static final String RESOURCE_PACKAGE_NAME = "com.lxs.mms.rs.resource";
    /**
     * 覆盖jersey logging 自带的jul logger
     */
    private static final Logger REQ_RESP_LOGGER = Logger.getLogger("payload-logger");
    @Value("${spring.profiles.active}")
    private String activeProfile;

    public JerseyConfig() {
        // logging
        enableLogging();

        // 配置Swagger
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        packages(RESOURCE_PACKAGE_NAME);
    }

    /**
     * 开启日志，适配jul logging
     */
    private void enableLogging() {
        // 移除根日志处理器
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        // 绑定新的处理器
        SLF4JBridgeHandler.install();
        // 请求 响应日志
        REQ_RESP_LOGGER.setLevel(Level.FINE);
        LoggingFeature lf = new LoggingFeature(REQ_RESP_LOGGER);
        register(lf);
    }

    /**
     * 当dev环境时开启wadl的生成。<br/>
     * 因要在构造后获取active profile所以需在PostConstruct时进行初始化。
     */
    @PostConstruct
    private void enableWadl() {
        // wadl feature默认就是开启
        if ("dev".equalsIgnoreCase(activeProfile)) {
            log.warn("Current env is dev,enable wadl feature");
            return;
        }
        log.info("Current env is prod，disable wadl feature");
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
    }
}
