package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Region;
import com.youzhihua.bs.service.RegionService;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
public class RegionController {

    @Autowired
    private RegionService regionService;

    @RequestMapping("/regionAction_importXls.action")
    public void importXls(@RequestParam("regionFile")MultipartFile regionFile) throws IOException {
        regionService.impotRrgion(regionFile);
    }

    //取派员分页查询
    @RequestMapping("/regionAction_pageQuery")
    @ResponseBody
    public PageBean<Region> selectList(int page, int rows){
        PageBean<Region> itemByPage = regionService.findItemByPage(page, rows);
        return itemByPage;
    }

    @RequestMapping("/regionAction_listajax.action")
    @ResponseBody
    public List<Region> list(){
        return regionService.findAll();
    }

}
