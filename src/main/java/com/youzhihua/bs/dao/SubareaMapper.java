package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.Subarea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubareaMapper {
    int deleteByPrimaryKey(String id);

    int insert(Subarea record);

    Subarea selectByPrimaryKey(String id);

    List<Subarea> selectAll();

    int updateByPrimaryKey(Subarea record);

    int countItem();

}