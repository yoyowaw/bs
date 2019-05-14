package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Decidedzone;
import com.youzhihua.bs.service.DecidedzoneServece;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import com.youzhihua.bs.request.AddDecideZoneRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api(value = "定区管理",tags = "定区")
public class DecideZoneController {
    @Autowired
    private DecidedzoneServece decidedzoneServece;

    @Autowired
    private HttpServletRequest request;

    @PostMapping("/decidedzone_add")
    @ApiOperation("添加定区")
    public Result add(AddDecideZoneRequest request){
        decidedzoneServece.add(request);
        return ResultUtils.success();
    }

    @GetMapping("/decidedzone_list")
    @ResponseBody
    public PageBean<Decidedzone> list(int page, int rows){
        PageBean<Decidedzone> itemByPage = decidedzoneServece.findItemByPage(page, rows);
        return itemByPage;
    }

}
