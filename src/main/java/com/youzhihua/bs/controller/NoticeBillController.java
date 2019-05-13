package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.QpNoticebill;
import com.youzhihua.bs.dao.entity.QpWorkbill;
import com.youzhihua.bs.dao.entity.QpWorkordermanege;
import com.youzhihua.bs.service.NoticeBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class NoticeBillController {

    @Autowired
    private NoticeBillService service;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("noticebill_add")
    public String add(){
        String telephone = request.getParameter("telephone");
        String customerId = request.getParameter("customerId");
        String customerName = request.getParameter("customerName");
        String delegater = request.getParameter("delegater");
        String product = request.getParameter("product");
        String num = request.getParameter("num");
        String weight = request.getParameter("weight");
        String volume = request.getParameter("volume");
        String pickaddress = request.getParameter("pickaddress");
        String arrivecity = request.getParameter("arrivecity");
        String remark = request.getParameter("remark");
        QpNoticebill noticebill = new QpNoticebill();
        noticebill.setCustomerId(Integer.valueOf(customerId));
        noticebill.setCustomerName(customerName);
        noticebill.setDelegater(delegater);
        noticebill.setPickaddress(pickaddress);
        noticebill.setRemark(remark);
        noticebill.setWeight(Double.valueOf(weight));
        noticebill.setVolume(volume);
        noticebill.setNum(Integer.valueOf(num));
        noticebill.setArrivecity(arrivecity);
        service.save(noticebill);
        return "/WEB-INF/pages/qupai/noticebill_add";
    }

    @RequestMapping("work_add")
    public String addwork(QpWorkordermanege qpWorkbill){
        String arrivecity = request.getParameter("arrivecity");
        String product = request.getParameter("product");
        String num = request.getParameter("num");
        String weight = request.getParameter("weight");
        String floadreqr = request.getParameter("floadreqr");
        service.addwork(qpWorkbill);
        return "/WEB-INF/pages/qupai/quickworkorder";
    }
}
