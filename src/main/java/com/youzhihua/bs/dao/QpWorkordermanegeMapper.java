package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.QpWorkordermanege;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QpWorkordermanegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QpWorkordermanege record);

    QpWorkordermanege selectByPrimaryKey(Integer id);

    List<QpWorkordermanege> selectAll();

    int updateByPrimaryKey(QpWorkordermanege record);
}