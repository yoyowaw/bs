package com.youzhihua.bs.dao.entity;

import lombok.Data;

/**
 * @Author youzhihua
 * @Date 2019/5/14 10:38
 */
@Data
public class RoleHasResource {

    private Integer id;

    private Integer roleId;

    private String resourceIds;

}
