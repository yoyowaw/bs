package com.youzhihua.bs.controller;

import com.youzhihua.bs.dao.entity.TCustomer;
import com.youzhihua.bs.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/findNotLink")
    @ResponseBody
    public List<TCustomer> findNotLink(){
        return customerService.findNotLink();
    }

    @RequestMapping("/findLink")
    @ResponseBody
    public List<TCustomer> findLink(@RequestBody String id){
        String[] split = id.split("=");

        return customerService.findLink(Integer.valueOf(split[1]));
    }
    @RequestMapping("/findLinkid/{id}")
    @ResponseBody
    public List<TCustomer> findLinkId(@PathVariable("id") String id){

        return customerService.findLink(Integer.valueOf(id));
    }

    @RequestMapping("link_customer")
    @ResponseBody
    public String linkCustomer(Integer id , String customerIds){
        customerService.linkCustomer(id,customerIds);
        return "/WEB-INF/pages/base/decidedzone";
    }

    @RequestMapping("/{telephone}")
    @ResponseBody
    public TCustomer getCustomerByTelephone(@RequestBody String telephone){
        String[] split = telephone.split("=");
        return customerService.findCustomerByTelephone(split[1]);
    }

    @RequestMapping("findIdByAddress")
    @ResponseBody
    public String findIdByAddress(@RequestBody String address){

        return customerService.findIdByAddress(address);

    }

}
