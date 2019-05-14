package com.youzhihua.bs.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/13 21:21
 */
@ApiModel("关联客户请求参数")
@Data
public class LinkCustomerRequest {

    @ApiModelProperty("定区id")
    private Integer id;

    @ApiModelProperty("客户id列表 逗号隔开")
    private String customerIds;

}
