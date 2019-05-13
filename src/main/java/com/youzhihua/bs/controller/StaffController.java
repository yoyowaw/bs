package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Staff;
import com.youzhihua.bs.service.StaffService;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @RequestMapping("/staffAction_add")
    public String add(Staff staff){
        staffService.save(staff);
        return "/WEB-INF/pages/base/staff";
    }

    //取派员分页查询
    @RequestMapping("/staffAction_pageQuery")
    @ResponseBody
    public PageBean<Staff> selectList(int page, int rows){
        PageBean<Staff> itemByPage = staffService.findItemByPage(page, rows);
        return itemByPage;
    }
    @RequestMapping("/staff_query")
    @ResponseBody
    public List<Staff> findAll(){
        return staffService.findAll();
    }


    //删除员工
    @RequestMapping("staffAction_delete/{ids}")
    public String deleteStaff(@PathVariable(value = "ids") String ids){
        staffService.deleteStaff(ids);
        return "/WEB-INF/pages/base/staff";
    }

    @RequestMapping("/staffAction_edit")
    public String edit(Staff staff){
        staffService.edit(staff);
        return "/WEB-INF/pages/base/staff";
    }




}
