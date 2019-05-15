package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Region;
import com.youzhihua.bs.service.RegionService;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@Api("分区管理")
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
    public PageBean<Region> selectList(Integer page, Integer rows){
        PageBean<Region> itemByPage = regionService.findItemByPage(page, rows);
        return itemByPage;
    }

    @GetMapping("/regionAction_listajax.action")
    @ResponseBody
    @ApiOperation("获取分区列表")
    public List<Region> list(){
        return regionService.findAll();
    }

    //删除分页
    @GetMapping("/del-region/{id}")
    @ResponseBody
    public Result del(@PathVariable("id") String id){
        regionService.delRegion(id);
        return ResultUtils.success();
    }

    @PostMapping("/add-region")
    public Result add(@RequestBody Region region){
        regionService.add(region);
        return ResultUtils.success();
    }

    @PostMapping("/edit-region")
    public Result edit(@RequestBody Region region){
        regionService.edit(region);
        return ResultUtils.success();
    }

}
