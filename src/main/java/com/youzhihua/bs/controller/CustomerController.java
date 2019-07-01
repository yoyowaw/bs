package com.youzhihua.bs.controller;

import com.youzhihua.bs.request.LinkCustomerRequest;
import com.youzhihua.bs.dao.entity.TCustomer;
import com.youzhihua.bs.service.CustomerService;
import com.youzhihua.bs.utils.Result;
import com.youzhihua.bs.utils.ResultUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Api(value = "客户管理",tags = "客户管理")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/findNotLink")
    @ResponseBody
    @ApiOperation("查询未关联的用户")
    public List<TCustomer> findNotLink(){
        return customerService.findNotLink();
    }

    @GetMapping("/findLink/{id}")
    @ResponseBody
    @ApiOperation("查询已经关联的用户")
    public List<TCustomer> findLink(@PathVariable("id")Integer id){
        return customerService.findLink(id);
    }
    @GetMapping("/find-link/{id}")
    @ResponseBody
    @ApiOperation("根据定区id查询关联用户")
    public List<TCustomer> findLinkId(@PathVariable("id") String id){

        return customerService.findLink(Integer.valueOf(id));
    }

    @PostMapping("link-customer")
    @ResponseBody
    @ApiOperation("定区关联客户")
    public Result linkCustomer(@RequestBody LinkCustomerRequest request){
        customerService.linkCustomer(request);
        return ResultUtils.success();
    }

    @GetMapping("find-customer-by-telephone/{telephone}")
    @ResponseBody
    @ApiOperation("根据电话号码查询用户")
    public TCustomer getCustomerByTelephone(@PathVariable("telephone") String telephone){
        String[] split = telephone.split("=");
        return customerService.findCustomerByTelephone(split[1]);
    }

    @PostMapping("find-id-by-address")
    @ResponseBody
    @ApiOperation("根据地址获取客户id")
    public String findIdByAddress(@RequestBody String address){

        return customerService.findIdByAddress(address);

    }

    @GetMapping("/find-customer")
    @ResponseBody
    @ApiOperation("根据地址获取客户id")
    public List<TCustomer> findCusotmer(){

        return customerService.findCusotmer();

    }

}
