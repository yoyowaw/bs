package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Region;
import com.youzhihua.bs.service.RegionService;
import com.youzhihua.bs.utils.PageBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Api("区域管理")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ApiOperation("区域导入")
    @PostMapping("/regionAction_importXls.action")
    public void importXls(@RequestParam("regionFile")MultipartFile regionFile) throws IOException {
        regionService.impotRrgion(regionFile);
    }

    //取派员分页查询
    @ApiOperation("区派员分页查询")
    @GetMapping("/regionAction_pageQuery")
    @ResponseBody
    public PageBean<Region> selectList(int page, int rows){
        PageBean<Region> itemByPage = regionService.findItemByPage(page, rows);
        return itemByPage;
    }

    @GetMapping("/regionAction_listajax.action")
    @ResponseBody
    @ApiOperation("获取分区列表")
    public List<Region> list(){
        return regionService.findAll();
    }

}
