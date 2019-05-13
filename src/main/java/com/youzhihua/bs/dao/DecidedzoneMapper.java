package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.Decidedzone;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DecidedzoneMapper {
    int deleteByPrimaryKey(String id);

    int insert(Decidedzone record);

    Decidedzone selectByPrimaryKey(String id);

    List<Decidedzone> selectAll();

    int updateByPrimaryKey(Decidedzone record);

    int countItem();
}