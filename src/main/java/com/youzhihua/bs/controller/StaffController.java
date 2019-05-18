package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Staff;
import com.youzhihua.bs.service.StaffService;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "取派员管理",tags = "取派员管理")
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;

    @ApiOperation("增加取派员")
    @PostMapping("/staffAction-add")
    public Result add(@RequestBody Staff staff){
        staffService.save(staff);
        return ResultUtils.success();
    }

    //取派员分页查询
    @ApiOperation("区派员分页查询")
    @GetMapping("/staffAction_pageQuery")
    public PageBean<Staff> selectList(Integer page, Integer rows){
        PageBean<Staff> itemByPage = staffService.findItemByPage(page, rows);
        return itemByPage;
    }

    @GetMapping("/staff_query")
    @ApiOperation("取派员列表")
    public List<Staff> findAll(){
        return staffService.findAll();
    }


    //删除员工
    @ApiOperation("删除取派员")
    @GetMapping("staffAction_delete/{ids}")
    public Result deleteStaff(@PathVariable(value = "ids")@ApiParam("取派员id列表") String ids){
        staffService.deleteStaff(ids);
        return ResultUtils.success();
    }

    @ApiOperation("修改取派员")
    @PostMapping("/staffAction_edit")
    public Boolean edit(@RequestBody Staff staff){
        staffService.edit(staff);
        return true;
    }




}
