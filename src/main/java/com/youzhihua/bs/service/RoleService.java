package com.youzhihua.bs.service;

import com.youzhihua.bs.dao.RoleHasResourceMapper;
import com.youzhihua.bs.dao.TRoleMapper;
import com.youzhihua.bs.dao.entity.RoleHasResource;
import com.youzhihua.bs.dao.entity.TRole;
import com.youzhihua.bs.request.AddRuleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author youzhihua
 * @Date 2019/5/14 10:31
 */
@Service
public class RoleService {

    @Autowired
    private RoleHasResourceMapper roleHasResourceMapper;

    @Autowired
    private TRoleMapper tRoleMapper;

    public void addRule( AddRuleRequest request){
        TRole role = new TRole();
        role.setName(request.getName());
        tRoleMapper.insert(role);
        RoleHasResource resource = new RoleHasResource();
        resource.setRoleId(role.getRoleId());
        resource.setResourceIds(request.getMenuIds());
        roleHasResourceMapper.insert(resource);
    }

}
