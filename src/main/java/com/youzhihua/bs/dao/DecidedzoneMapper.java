package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.Decidedzone;
import com.youzhihua.bs.request.ZoneRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DecidedzoneMapper {
    int deleteByPrimaryKey(String id);

    int insert(Decidedzone record);

    Decidedzone selectByPrimaryKey(String id);

    List<Decidedzone> selectAll();

    int updateByPrimaryKey(Decidedzone record);

    int countItem();

    int deleteByRId(@Param("id") String id);

    List<Decidedzone> selectByName(ZoneRequest zoneRequest);
}