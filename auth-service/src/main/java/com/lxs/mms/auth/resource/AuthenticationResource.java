package com.lxs.mms.auth.resource;

import com.lxs.mms.auth.config.TokenConfig;
import com.lxs.mms.auth.db.mongo.bean.TokenCollection;
import com.lxs.mms.auth.db.mongo.service.TokenService;
import com.lxs.mms.auth.resource.bean.RefreshTokenRequest;
import com.lxs.mms.auth.resource.bean.RefreshTokenResponse;
import com.lxs.mms.rest.service.core.jersey.ResourceSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * 提供对与认证用户、令牌检测相关接口。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Component
@Path("/auth/v1")
@Api(value = "用户认证服务", produces = "application/json")
@Log4j2
public class AuthenticationResource extends ResourceSupport {
    @Autowired
    private TokenConfig tokenConfig;
    @Autowired
    private TokenService tokenService;

    @POST
    @Path("/refreshToken")
    @ApiOperation(
            value = "刷新Token",
            notes = "检查Token是否合法并进行检测与刷新",
            httpMethod = "POST",
            response = RefreshTokenResponse.class
    )
    @ApiResponse(code = 200, message = "成功true", response = RefreshTokenResponse.class)
    public RefreshTokenResponse refreshToken(@Valid @NotNull(message = "登录失败，账号密码不可为空。")
                                                     RefreshTokenRequest request) {
        TokenCollection tc = tokenService.updateToken(request.getToken());
        System.out.println(tc);
        RefreshTokenResponse r = new RefreshTokenResponse();
        r.setStatus(RefreshTokenResponse.Status.REFRESHED);
        return r;
    }

//    private String genJwtToken(String userName){
//        Claims c=new DefaultClaims();
//        c.setSubject(userName);
//        c.setIssuer(tokenConfig.getIssuer());
//        c.setIssuedAt(new Date());
//
//        c.setExpiration()
//        Jwts.builder().setClaims();
//        return null;
//
//    }
}
