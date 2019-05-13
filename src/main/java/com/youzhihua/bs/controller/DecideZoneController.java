package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.Decidedzone;
import com.youzhihua.bs.service.DecidedzoneServece;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DecideZoneController {
    @Autowired
    private DecidedzoneServece decidedzoneServece;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/decidedzone_add")
    public void add(Decidedzone decidedzone){
        String staffId = (String)request.getParameter("staff.id");

        decidedzone.setStaffId(staffId);
        decidedzoneServece.add(decidedzone);

    }

    @RequestMapping("/decidedzone_list")
    @ResponseBody
    public PageBean<Decidedzone> list(int page, int rows){
        PageBean<Decidedzone> itemByPage = decidedzoneServece.findItemByPage(page, rows);
        return itemByPage;
    }

}
