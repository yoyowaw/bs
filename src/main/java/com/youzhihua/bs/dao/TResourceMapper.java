package com.youzhihua.bs.dao;

import com.youzhihua.bs.dao.entity.TResource;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author youzhihua
 * @Date 2019/5/14 11:19
 */
@Mapper
public interface TResourceMapper {

    TResource getByid(Integer id);

    List<TResource> findAll();
}
