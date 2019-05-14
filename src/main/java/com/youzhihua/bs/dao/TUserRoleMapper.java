package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.TUserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author youzhihua
 * @Date 2019/5/14 9:37
 */
@Mapper
public interface TUserRoleMapper {

    List<TUserRole> selectByUserId(@Param("userId") Integer userId);


    void insert(TUserRole userRole);
}
