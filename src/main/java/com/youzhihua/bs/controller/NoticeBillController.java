package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.QpNoticebill;
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
    @ApiOperation("添加新单")
    public Result add(@RequestBody QpNoticebill noticebill){
        service.save(noticebill);
        return ResultUtils.success();
    }

    @ApiOperation("删除工作单")
    @GetMapping("/del-bill/{id}")
    public Result del(@PathVariable("id") Integer id){
        service.del(id);
        return ResultUtils.success();
    }
    @ApiOperation("工作单列表")
    @GetMapping("/get-notice-bill-list")
    public PageBean<QpNoticebill> getBills(Integer page,Integer rows){
        return service.select(page,rows);
    }
    @PostMapping("/work_add")
    public String addwork(QpWorkordermanege qpWorkbill){
        service.addwork(qpWorkbill);
        return "/WEB-INF/pages/qupai/quickworkorder";
    }


}
