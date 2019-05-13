package com.youzhihua.bs.controller;

import com.sun.deploy.net.HttpResponse;
import com.youzhihua.bs.dao.entity.TUser;
import com.youzhihua.bs.dto.UserLoginDTO;
import com.youzhihua.bs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //用户登录
    @PostMapping("/userLogin")
    public String uerLogin(UserLoginDTO userLoginDTO){
        return userService.userLogin(userLoginDTO);
    }

    //用户注销
    @RequestMapping("/userLoginOut")
    public String userLoginOut(){
        userService.loginOut();
        return "login";
    }

    @PostMapping("/user-edit-pwd")
    @ResponseBody
    public String editPwd(@RequestBody TUser user){
        try {
            userService.editPew(user);
            return "1";
        }catch (Exception e){
            return "0";
        }
    }
}
