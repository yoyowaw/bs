package com.youzhihua.bs.dao.entity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class QpNoticebill implements Serializable {

    private Integer id;



    private Integer staffId;
    private Integer customerId;

    private String customerName;

    private String delegater;

    private String pickaddress;

    private String arrivecity;

    private String product;

    private Integer num;

    private Double weight;

    private String volume;

    private String remark;

    private String ordertype;

    private String userId;

    private String staffName;
}