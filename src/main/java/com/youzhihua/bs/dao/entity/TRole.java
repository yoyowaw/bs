package com.youzhihua.bs.dao.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/14 8:13
 */
@Data
@ApiModel("权限")
public class TRole {

    private Integer roleId;

    @ApiModelProperty("权限名称")
    private String name;

    private String desc;

}
