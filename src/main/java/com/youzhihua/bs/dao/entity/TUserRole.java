package com.youzhihua.bs.dao.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author youzhihua
 * @Date 2019/5/14 8:33
 */
@Data
public class TUserRole  implements Serializable {

    private Integer id;

    private Integer userId;

    private Integer roleId;

}
