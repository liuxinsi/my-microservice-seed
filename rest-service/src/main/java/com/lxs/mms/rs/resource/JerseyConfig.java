package com.lxs.mms.rs.resource;

import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.stereotype.Component;

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
@ApplicationPath("services")
public class JerseyConfig extends ResourceConfig {
    /**
     * 覆盖jersey logging 自带的jul logger
     */
    private static final Logger REQ_RESP_LOGGER = Logger.getLogger("payload-logger");

    public JerseyConfig() {
        // 移除根日志处理器
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        // 绑定新的处理器
        SLF4JBridgeHandler.install();
        // 请求 响应日志
        REQ_RESP_LOGGER.setLevel(Level.FINE);
        LoggingFeature lf = new LoggingFeature(REQ_RESP_LOGGER);
        register(lf);

        packages("com.lxs.mms.rs.resource");
    }
}
