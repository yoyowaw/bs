package com.youzhihua.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/13 21:41
 */
@Data
@ApiModel("用户登录请求参数")
public class UserLoginRequest {

    @ApiModelProperty("验证码")
    private String checkCode;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

}
