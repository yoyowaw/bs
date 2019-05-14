package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.QpNoticebill;
import com.youzhihua.bs.dao.entity.QpWorkordermanege;
import com.youzhihua.bs.service.NoticeBillService;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("work_add")
    public String addwork(QpWorkordermanege qpWorkbill){
        service.addwork(qpWorkbill);
        return "/WEB-INF/pages/qupai/quickworkorder";
    }
}
