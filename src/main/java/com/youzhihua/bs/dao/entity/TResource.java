package com.youzhihua.bs.dao.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author youzhihua
 * @Date 2019/5/14 11:18
 */
@Data
public class TResource {

    private Integer id;

    private String name;

    private String url;

    private Integer parent;

    private List<TResource> tResource;

}
