package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Subarea;
import com.youzhihua.bs.dto.SubareaQueryContion;
import com.youzhihua.bs.service.SubareaService;
import com.youzhihua.bs.utils.PageBean;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@Api(value = "分区管理",tags = "定区管理")
public class SubareaController {

    @Autowired
    private SubareaService subareaService;
    @Autowired
    private HttpServletRequest servletRequest;

    @PostMapping("/su-add")
    @ApiModelProperty("添加定区")
    public Result add(@RequestBody Subarea subarea){
        subareaService.save( subarea);
        return ResultUtils.success();
    }

    @GetMapping("/subareaAction_pageQuery")
    @ResponseBody
    @ApiOperation("查找分区")
    public PageBean<Subarea>  queryList(
            String addresskey, int page, int rows){
        String province = servletRequest.getParameter("region.province");
        String city = servletRequest.getParameter("region.city");
        String district = servletRequest.getParameter("region.district");
        SubareaQueryContion subareaQueryContion = new SubareaQueryContion(province,city,district,addresskey);
        PageBean<Subarea> all = subareaService.findAll(page, rows,subareaQueryContion);
        return all;
    }

    @GetMapping("/subareaAction_export")
    @ApiOperation(value = "导出分区")
    public void export(HttpServletResponse response) throws IOException {
        List<Subarea> subareas = subareaService.queryAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("分区数据");
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("分区编号");
        row.createCell(1).setCellValue("开始编号");
        row.createCell(2).setCellValue("结束编号");
        row.createCell(3).setCellValue("位置信息");
        row.createCell(4).setCellValue("省市区");
        int i = 0;
        for (Subarea subarea : subareas) {
            HSSFRow row1 = sheet.createRow(++i);
            row1.createCell(0).setCellValue(subarea.getId());
            row1.createCell(1).setCellValue(subarea.getStartnum());
            row1.createCell(2).setCellValue(subarea.getEndnum());
            row1.createCell(3).setCellValue(subarea.getPosition());
            row1.createCell(4).setCellValue(subarea.getRegionId());
        }
        ServletOutputStream outputStream = response.getOutputStream();
        response.setHeader("content-disposition","attachment:filename=subarea.xls");
        response.setContentType("application/vnd.ms-excel");
        workbook.write(outputStream);


    }

    @GetMapping("/subareaAction_list")
    @ApiOperation("定区列表")
    public List<Subarea> list(){
        return subareaService.queryAll();
    }

    @ResponseBody
    @ApiOperation("根据id查找分区")
    @RequestMapping("/subarea_findList/{id}")
    public List<Subarea> findList(@PathVariable("id") String id){
        return subareaService.findList(id);
    }



}
