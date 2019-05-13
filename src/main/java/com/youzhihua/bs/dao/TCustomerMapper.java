package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.TCustomer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TCustomerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCustomer record);

    TCustomer selectByPrimaryKey(Integer id);

    List<TCustomer> selectAll();

    int updateByPrimaryKey(TCustomer record);

    List<TCustomer> findLink(@Param("id") Integer id);

    List<TCustomer> findNotLink();

    void clearLink(@Param("id") Integer id);

    void link(@Param("id") Integer id , @Param("cid") Integer cid);

    TCustomer getCustomerByTelephone(@Param("telephone") String telephone);

    String getIdByAddress(@Param("address") String address);
}