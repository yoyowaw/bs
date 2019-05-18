package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.QpNoticebill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QpNoticebillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QpNoticebill record);

    QpNoticebill selectByPrimaryKey(Integer id);

    List<QpNoticebill> selectAll();

    int updateByPrimaryKey(QpNoticebill record);

    int countItem();
}