package com.youzhihua.bs.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Author youzhihua
 * @Date 2019/5/13 21:49
 */
@Api(value = "验证码接口" ,tags = "验证码")
@RestController
@RequestMapping("/code")
public class CodeController {
    @Autowired
    private HttpSession session;

    @GetMapping("/get-code")
    @ApiOperation("获取验证码")
    public String getCode(){
        int i = (int)((Math.random()*9+1)*1000);
        String s = String.valueOf(i);
        session.setAttribute("code",s);
        return s;
    }



}
