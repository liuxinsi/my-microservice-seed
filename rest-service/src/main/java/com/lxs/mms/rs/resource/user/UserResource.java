package com.lxs.mms.rs.resource.user;

import com.lxs.mms.rs.resource.ResourceSupport;
import com.lxs.mms.rs.resource.bean.user.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liuxinsi
 * @mail akalxs@gmail.com
 */
@Component
@Path("/user/v1")
@Api(value = "用户相关服务", produces = "application/json")
public class UserResource extends ResourceSupport {
    /**
     * 获取所有用户。
     *
     * @return 用户信息列表
     */
    @GET
    @Path("/loadUsers")
    @ApiOperation(
            value = "加载所有用户",
            notes = "数据了大要分页",
            response = UserInfo.class,
            responseContainer = "List"
    )
    public List<UserInfo> loadUsers() {
        List<UserInfo> userInfos = new ArrayList<>(10);
        for (int i = 0; i < 100; i++) {
            UserInfo u = new UserInfo();
            u.setId(i + "");
            u.setName("u" + i);
            u.setPwd("");
            u.setRegisteDate(new Date());
            userInfos.add(u);
        }
        return userInfos;
    }
}
