package com.youzhihua.bs.dao.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Decidedzone implements Serializable {

    private String id;

    private String name;

    private String staffId;

    private String subareaid;

    private Staff staff;

    private Region region;


}