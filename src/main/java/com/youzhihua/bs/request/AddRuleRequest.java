package com.youzhihua.bs.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/14 10:11
 */
@ApiModel("添加角色请求参数")
@Data
public class AddRuleRequest {

    @ApiModelProperty("角色名称")
    private String name;

    private String desc;
    @ApiModelProperty("角色拥有的菜单,菜单id逗号隔开")
    private String menuIds;

}
