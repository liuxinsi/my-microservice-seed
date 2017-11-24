package com.lxs.mms.auth.resource.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 对应{@link com.lxs.mms.auth.resource.AuthenticationResource#refreshToken(RefreshTokenRequest)} (RefreshTokenResponse)}响应。
 *
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Data
@ApiModel(value = "刷新Token响应", description = "")
public class RefreshTokenResponse {
    @ApiModelProperty(value = "状态")
    private Status status;

    @ApiModel(value = "刷新状态")
    public enum Status {
        @ApiModelProperty(value = "已刷新")
        REFRESHED,
        @ApiModelProperty(value = "不存在")
        UNEXIST
    }
}
