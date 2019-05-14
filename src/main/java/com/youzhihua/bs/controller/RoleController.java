package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.TResource;
import com.youzhihua.bs.request.AddRuleRequest;
import com.youzhihua.bs.service.RoleService;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author youzhihua
 * @Date 2019/5/14 8:46
 */
@RestController
@Api("角色管理")
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService service;

    @ApiOperation("新增角色")
    @PostMapping("/add-rule")
    public Result addRule(@RequestBody AddRuleRequest request){
        service.addRule(request);
        return ResultUtils.success();
    }

    @ApiOperation("根据角色id查询菜单")
    @GetMapping("/get-menu-by-roleid/{roleId}")
    public Result getMenu(@PathVariable("roleId") Integer roleId){
        List<TResource> byId = service.getById(roleId);
        return ResultUtils.success(byId);
    }

    @ApiOperation("获取所有的菜单")
    @GetMapping("/get-menu")
    public Result findMenu(){
        List<TResource> lists = service.findMenu();
        return ResultUtils.success(lists);
    }



}
