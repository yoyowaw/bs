package com.youzhihua.bs.controller;

import com.sun.deploy.net.HttpResponse;
import com.youzhihua.bs.dao.entity.TUser;
import com.youzhihua.bs.dto.UserLoginDTO;
import com.youzhihua.bs.service.UserService;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.request.UserLoginRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Api("用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<UserLoginDTO> uerLogin(@RequestBody UserLoginRequest request){
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        BeanUtils.copyProperties(request,userLoginDTO);
        return userService.userLogin(userLoginDTO);
    }

    //用户注销
    @ApiOperation("用户登出")
    @GetMapping("/user-loginOut")
    public Boolean userLoginOut(){
        userService.loginOut();
        return true;
    }

    @ApiOperation("修改密码")
    @PostMapping("/user-edit-pwd")
    @ResponseBody
    public Boolean editPwd(@RequestBody TUser user){
        try {
            userService.editPew(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
