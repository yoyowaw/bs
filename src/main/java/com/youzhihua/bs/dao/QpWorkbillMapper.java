package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.QpWorkbill;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface QpWorkbillMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(QpWorkbill record);

    QpWorkbill selectByPrimaryKey(Integer id);

    List<QpWorkbill> selectAll();

    int updateByPrimaryKey(QpWorkbill record);
}