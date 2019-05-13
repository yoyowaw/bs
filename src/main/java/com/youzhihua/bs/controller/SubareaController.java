package com.youzhihua.bs.controller;

import com.sun.deploy.net.HttpResponse;
import com.youzhihua.bs.dao.entity.Region;
import com.youzhihua.bs.dao.entity.Subarea;
import com.youzhihua.bs.dto.SubareaQueryContion;
import com.youzhihua.bs.service.SubareaService;
import com.youzhihua.bs.utils.PageBean;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.attribute.standard.SheetCollate;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SubareaController {

    @Autowired
    private SubareaService subareaService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/su")
    public String add(Subarea subarea){
        subareaService.save( subarea);
        return "/WEB-INF/pages/base/subarea";
    }

    @RequestMapping("/subareaAction_pageQuery")
    @ResponseBody
    public PageBean<Subarea>  queryList(
            String addresskey, int page, int rows){
        String province = request.getParameter("region.province");
        String city = request.getParameter("region.city");
        String district = request.getParameter("region.district");
        SubareaQueryContion subareaQueryContion = new SubareaQueryContion(province,city,district,addresskey);
        PageBean<Subarea> all = subareaService.findAll(page, rows,subareaQueryContion);
        return all;
    }

    @RequestMapping("/subareaAction_export")
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

    @RequestMapping("/subareaAction_list")
    @ResponseBody
    public List<Subarea> list(){
        return subareaService.queryAll();
    }

    @ResponseBody
    @RequestMapping("/subarea_findList")
    public List<Subarea> findList(@RequestParam("id") String id){
        return subareaService.findList(id);
    }



}
