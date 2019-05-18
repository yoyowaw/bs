package com.youzhihua.bs.response;

import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/15 19:08
 */
@Data
public class SubareaResponse {
    private String id;
    private String province;
    private String city;
    private String district;
    private String addressKey;
    private String startnum;
    private String endnum;
    private String single;
    private String position;
}
