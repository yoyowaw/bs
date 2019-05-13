package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.TUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TUser record);

    TUser selectByPrimaryKey(String id);

    List<TUser> selectAll();

    int updateByPrimaryKey(TUser record);

    TUser selectByName(String name);

    void updatePwd(TUser tuser);
}