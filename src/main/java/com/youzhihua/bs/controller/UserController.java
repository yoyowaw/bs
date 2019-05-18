package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.TResource;
import com.youzhihua.bs.dao.entity.TUser;
import com.youzhihua.bs.dto.UserLoginDTO;
import com.youzhihua.bs.response.UserLoginResponse;
import com.youzhihua.bs.service.RoleService;
import com.youzhihua.bs.service.UserService;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.request.UserLoginRequest;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("用户管理")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService service;

    @Autowired
    private HttpServletResponse httpServletResponse;


    @Autowired
    private HttpServletRequest httpServletRequest;

    //用户登录
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result uerLogin(@RequestBody UserLoginRequest request){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        UserLoginDTO userLoginDTO = new UserLoginDTO();
        BeanUtils.copyProperties(request,userLoginDTO);
        UserLoginResponse response = new UserLoginResponse();
        Result<UserLoginDTO> result = userService.userLogin(userLoginDTO);
        if(!result.isSuccess()){
            return result;
        }
        List<TResource> byId = service.getById(result.getData().getRoleId());
        response.setUserLoginDTO(result.getData());
        response.setResources(byId);
        return ResultUtils.success(response);
    }

    //用户注销
    @ApiOperation("用户登出")
    @GetMapping("/user-loginOut")
    public Boolean userLoginOut(){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        userService.loginOut();
        return true;
    }

    @ApiOperation("修改密码")
    @PostMapping("/user-edit-pwd")
    @ResponseBody
    public Boolean editPwd(@RequestBody TUser user){
        httpServletResponse.setHeader("Access-Control-Allow-Origin","*");
        try {
            userService.editPew(user);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @ApiOperation("增加用户")
    @PostMapping("/add-user")
    public Result addUser(@RequestBody TUser user){
        userService.add(user);
        return ResultUtils.success();
    }

    @GetMapping("/user-list")
    public PageBean<TUser> getUserList(Integer page  , Integer rows){
        return userService.selectLists(page,rows);
    }

    @GetMapping("/del-user/{id}")
    public Result delUser(@PathVariable("id") Integer id){
        userService.delUser(id);
        return ResultUtils.success();
    }

    @PostMapping("/edit-user")
    public Result editUser(@RequestBody TUser user){
        userService.editUser(user);
        return ResultUtils.success();
    }
}
