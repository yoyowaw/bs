package com.youzhihua.bs.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/13 21:39
 */
@Data
@ApiModel("添加定区请求参数")
public class AddDecideZoneRequest {

    private String id;

    @ApiModelProperty("定区名称")
    private String name;

    @ApiModelProperty("取派员名称")
    private Integer staffId;

    @ApiModelProperty("分区id列表 用,隔开")
    private String subareaid;


}
