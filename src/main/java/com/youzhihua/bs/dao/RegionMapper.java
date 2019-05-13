package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.Region;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegionMapper {
    int deleteByPrimaryKey(String id);

    int insert(Region record);

    Region selectByPrimaryKey(String id);

    List<Region> selectAll();

    int updateByPrimaryKey(Region record);


    int countItem();

}