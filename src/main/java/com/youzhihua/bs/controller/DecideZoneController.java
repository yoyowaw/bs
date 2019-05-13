package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Decidedzone;
import com.youzhihua.bs.service.DecidedzoneServece;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import com.youzhihua.request.AddDecideZoneRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Api("定区管理")
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

    @RequestMapping("/decidedzone_list")
    @ResponseBody
    public PageBean<Decidedzone> list(int page, int rows){
        PageBean<Decidedzone> itemByPage = decidedzoneServece.findItemByPage(page, rows);
        return itemByPage;
    }

}
