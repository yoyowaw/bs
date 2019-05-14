package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.TRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author youzhihua
 * @Date 2019/5/14 8:17
 */
@Mapper
public interface TRoleMapper {
    int insert(TRole tRole);
    List<TRole> select();

    TRole selectById(@Param("roleId") Integer roleId);
}
