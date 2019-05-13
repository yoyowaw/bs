package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StaffMapper {
    int deleteByPrimaryKey(String id);

    int insert(Staff record);

    Staff selectByPrimaryKey(String id);

    List<Staff> selectAll();

    int updateByPrimaryKey(Staff record);

    int countItem();

    void deleteById(@Param("id") String id);

}