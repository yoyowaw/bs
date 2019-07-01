package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.QpNoticebill;
import com.youzhihua.bs.dao.entity.QpWorkbill;
import com.youzhihua.bs.dao.entity.QpWorkordermanege;
import com.youzhihua.bs.service.NoticeBillService;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("业务受理")
public class NoticeBillController {

    @Autowired
    private NoticeBillService service;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/noticebill_add")
    @ApiOperation("添加新业务单")
    public Result add(@RequestBody QpNoticebill noticebill){
        service.save(noticebill);
        return ResultUtils.success();
    }

    @ApiOperation("删除业务单")
    @GetMapping("/del-bill/{id}")
    public Result del(@PathVariable("id") Integer id){
        service.del(id);
        return ResultUtils.success();
    }
    @ApiOperation("业务单列表")
    @GetMapping("/get-notice-bill-list")
    public PageBean<QpNoticebill> getBills(Integer page,Integer rows){
        return service.select(page,rows);
    }
    @PostMapping("/work_add")
    public Result addwork(QpWorkordermanege qpWorkbill){
        service.addwork(qpWorkbill);
        return ResultUtils.success();
    }

    @ApiOperation("工作单列表")
    @GetMapping("/get-work-list")
    public PageBean<QpWorkbill> listwork(Integer page,Integer rows){
        return service.getWorkList(page,rows);
    }

    @ApiOperation("删除工作单")
    @GetMapping("/del-work/{id}")
    public Result delWork(@PathVariable("id") Integer id){
        return service.delWorlk(id);
    }

    @ApiOperation("修改工作单")
    @PostMapping("/edit-worlk")
    public Result editWorlk(@RequestBody QpWorkbill workbill){
        service.editWorlk(workbill);
        return ResultUtils.success();
    }

    @ApiOperation("新增")
    @PostMapping("/add-work-bill")
    public Result addWorlkBill(@RequestBody QpWorkbill workbill){
        service.addWorlkBill(workbill);
        return ResultUtils.success();
    }

}
