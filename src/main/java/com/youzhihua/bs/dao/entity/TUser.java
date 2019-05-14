package com.youzhihua.bs.dao.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class TUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private Double salary;

    private Date birthday;

    private String gender;

    private String station;

    private String telephone;

    private String remark;

    private Integer roleId;


}