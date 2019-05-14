package com.youzhihua.bs.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("用户登录返回参数")
@Data
public class UserLoginDTO {

    @ApiModelProperty("验证码")
    private String checkCode;

    @ApiModelProperty("用户名")
    private String username;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("角色名称")
    private String name;

    @ApiModelProperty("角色id")
    private Integer roleId;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String checkCode, String username, String password) {
        this.checkCode = checkCode;
        this.username = username;
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
