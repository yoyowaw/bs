package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.RoleHasResource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author youzhihua
 * @Date 2019/5/14 10:33
 */
@Mapper
public interface RoleHasResourceMapper {

    int insert(RoleHasResource roleHasResource);

}
