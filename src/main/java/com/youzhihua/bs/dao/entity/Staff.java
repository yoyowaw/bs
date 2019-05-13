package com.youzhihua.bs.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel
@Data
public class Staff implements Serializable {

    @ApiModelProperty("取派员id")
    private String id;

    @ApiModelProperty("取派员m名称")
    private String name;


    @ApiModelProperty("取派员电话")
    private String telephone;


    @ApiModelProperty("是否有PDA 1有 0 无")
    private String haspda = "0";


    @ApiModelProperty("是否删除")
    private String deltag = "0";

    @ApiModelProperty("所属单位")
    private String station;

    @ApiModelProperty("取派标准")
    private String standard;

}