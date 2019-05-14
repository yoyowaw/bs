package com.youzhihua.bs.controller;

import com.youzhihua.bs.request.AddRuleRequest;
import com.youzhihua.bs.service.RoleService;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
