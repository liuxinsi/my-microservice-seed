package com.lxs.mms.rest.service.core.jersey;

import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import lombok.extern.slf4j.Slf4j;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.validation.ValidationFeature;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

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
@ApplicationPath(JerseyCoreConfig.DEFAULT_APPLICATION_PATH)
@Slf4j
public class JerseyCoreConfig extends ResourceConfig {
    /**
     * 默认的service根路径
     */
    public static final String DEFAULT_APPLICATION_PATH = "services";
    /**
     * 资源包名
     */
    public static String resourcePackageName;
    /**
     * 覆盖jersey logging 自带的jul logger
     */
    private static final Logger REQ_RESP_LOGGER = Logger.getLogger("payload-logger");
    @Autowired
    private Environment env;

    public JerseyCoreConfig(String resourcePackageName) {
        JerseyCoreConfig.resourcePackageName = resourcePackageName;

        // logging
        enableLogging();

        // 配置Swagger
        this.register(ApiListingResource.class);
        this.register(SwaggerSerializers.class);

        // bean验证
        this.register(ValidationFeature.class);
        this.register(ValidationExceptionMapper.class);

        // 发送验证错误回客户端
        this.property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE,true);

        // 文件上传
        this.register(MultiPartFeature.class);
        packages("com.lxs.mms.rest.service.core", resourcePackageName);
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
        String currentProfile = env.getProperty("spring.profiles.active");
        // wadl feature默认就是开启
        if ("dev".equalsIgnoreCase(currentProfile)) {
            log.warn("Current env is dev,enable wadl feature");
            return;
        }
        log.info("Current env is prod，disable wadl feature");
        property(ServerProperties.WADL_FEATURE_DISABLE, true);
    }
}
