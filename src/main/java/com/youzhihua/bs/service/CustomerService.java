package com.youzhihua.bs.service;

import com.youzhihua.bs.dao.TCustomerMapper;
import com.youzhihua.bs.dao.entity.TCustomer;
import com.youzhihua.bs.request.LinkCustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private TCustomerMapper mapper;


    public List<TCustomer> findAll() {
        return mapper.selectAll();
    }

    public List<TCustomer> findLink(Integer id){
        return mapper.findLink(id);
    }

    public List<TCustomer> findNotLink() {
        return mapper.findNotLink();
    }

    public void linkCustomer(LinkCustomerRequest request) {
        String[] split = request.getCustomerIds().split(",");
        for (String s : split) {
            mapper.clearLink(Integer.valueOf(s));
            mapper.link(request.getId() , Integer.valueOf(s));
        }

    }

    public TCustomer findCustomerByTelephone(String telephone) {
        return mapper.getCustomerByTelephone(telephone);
    }

    public String findIdByAddress(String address) {
        return mapper.getIdByAddress(address);
    }

    public List<TCustomer> findCusotmer() {
        return mapper.selectAll();
    }
}
