package com.lxs.mms.auth.resource;

import com.lxs.mms.rest.service.core.jersey.ResourceSupport;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import javax.ws.rs.Path;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Component
@Path("/auth2/v1")
@Api(value = "用户授权服务", produces = "application/json")
@Log4j2
public class AuthorizationResource extends ResourceSupport {
}
