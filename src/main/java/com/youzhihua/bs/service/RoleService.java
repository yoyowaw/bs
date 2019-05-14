package com.youzhihua.bs.service;

import com.youzhihua.bs.dao.RoleHasResourceMapper;
import com.youzhihua.bs.dao.TResourceMapper;
import com.youzhihua.bs.dao.TRoleMapper;
import com.youzhihua.bs.dao.entity.RoleHasResource;
import com.youzhihua.bs.dao.entity.TResource;
import com.youzhihua.bs.dao.entity.TRole;
import com.youzhihua.bs.request.AddRuleRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private TResourceMapper tResourceMapper;

    public void addRule( AddRuleRequest request){
        TRole role = new TRole();
        role.setName(request.getName());
        tRoleMapper.insert(role);
        RoleHasResource resource = new RoleHasResource();
        resource.setRoleId(role.getRoleId());
        resource.setResourceIds(request.getMenuIds());
        roleHasResourceMapper.insert(resource);
    }

    public List<TResource> getById(Integer roleId) {
        List<RoleHasResource> roleHasResources = roleHasResourceMapper.selectByRoleId(roleId);
        if(CollectionUtils.isEmpty(roleHasResources)){
            return null;
        }
        List<TResource> result = new ArrayList();
        String[] split = roleHasResources.get(0).getResourceIds().split(",");
        for (String s : split) {
            TResource byid = tResourceMapper.getByid(Integer.valueOf(s));
            result.add(byid);
        }
        List<TResource> response = new ArrayList();
        for (TResource tResource : result) {
            if (tResource.getParent()==null || tResource.getParent() == 0){
                TResource resource = new TResource();
                BeanUtils.copyProperties(tResource,resource);
                response.add(tResource);
            }
        }

        for (TResource tResource : response) {
            List<TResource> resources = new ArrayList<>();
            for (TResource tResource1 : result) {
                if(tResource.getId() != tResource1.getId()&&tResource.getId() == tResource1.getParent()){
                    resources.add(tResource1);
                }
            }
            tResource.setTResource(resources);
        }


        for (TResource tResource : response) {
            List<TResource> resources = new ArrayList<>();
            for (TResource resource : tResource.getTResource()) {
                for (TResource tResource1 : result) {
                    if(tResource.getTResource()!=null){
                        if(tResource1.getParent() == resource.getId()){
                            resources.add(tResource1);
                        }
                    }

                }
                resource.setTResource(resources);
            }

        }
        return response;
    }

    public List<TResource> findMenu() {
        List<TResource> list = tResourceMapper.findAll();
        return list;
    }
}
