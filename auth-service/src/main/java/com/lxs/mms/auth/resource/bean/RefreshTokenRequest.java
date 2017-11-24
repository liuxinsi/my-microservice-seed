package com.lxs.mms.auth.resource.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 对应{@link com.lxs.mms.auth.resource.AuthenticationResource#refreshToken(RefreshTokenRequest)}传参。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Data
@ApiModel(value = "刷新Token请求", description = "token必填")
public class RefreshTokenRequest {
    @ApiModelProperty(value = "token",
            required = true,
            dataType = "String",
            example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKb2UifQ.yiV1GWDrQyCeoOswYTf_xvlgsnaVVYJM0mU6rkmRBf2T1MBl3Xh2kZii0Q9BdX5-G0j25Qv2WF4lA6jPl5GKuA")
    @NotEmpty(message = "token不可为空")
    private String token;
}
