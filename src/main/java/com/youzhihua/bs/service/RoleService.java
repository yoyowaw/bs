package com.youzhihua.bs.service;

import com.github.pagehelper.PageHelper;
import com.youzhihua.bs.dao.*;
import com.youzhihua.bs.dao.entity.RoleHasResource;
import com.youzhihua.bs.dao.entity.TResource;
import com.youzhihua.bs.dao.entity.TRole;
import com.youzhihua.bs.request.AddRuleRequest;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private TUserMapper tUserMapper;
    @Autowired
    private TUserRoleMapper tUserRoleMapper;

    public void addRule(AddRuleRequest request) {
        String menuIds = request.getMenuIds();
        String[] split = menuIds.split(",");
        for (String s : split) {
            TResource byid = tResourceMapper.getByid(Integer.valueOf(s));
            if (byid!=null&&byid.getParent()!=null&&byid.getParent()!=0){
                menuIds = menuIds + ","+byid.getParent();
            }
        }
        request.setMenuIds(menuIds);
        TRole role = new TRole();
        role.setName(request.getName());
        role.setDesc(request.getDesc());
        tRoleMapper.insert(role);
        RoleHasResource resource = new RoleHasResource();
        resource.setRoleId(role.getRoleId());
        resource.setResourceIds(request.getMenuIds());
        roleHasResourceMapper.insert(resource);
    }

    public List<TResource> getById(Integer roleId) {
        List<RoleHasResource> roleHasResources = roleHasResourceMapper.selectByRoleId(roleId);
        if (CollectionUtils.isEmpty(roleHasResources)) {
            return null;
        }
        List<TResource> result = new ArrayList();
        String[] split = roleHasResources.get(0).getResourceIds().split(",");
        for (String s : split) {
            TResource byid = tResourceMapper.getByid(Integer.valueOf(s));
            if (byid != null)
                result.add(byid);
        }
        List<TResource> response = new ArrayList();
        for (TResource tResource : result) {
            if (tResource.getParent() == null || tResource.getParent() == 0) {
                TResource resource = new TResource();
                BeanUtils.copyProperties(tResource, resource);
                response.add(tResource);
            }
        }

        for (TResource tResource : response) {
            List<TResource> resources = new ArrayList<>();
            for (TResource tResource1 : result) {
                if (tResource.getId() != tResource1.getId() && tResource.getId() == tResource1.getParent()) {
                    resources.add(tResource1);
                }
            }
            tResource.setTResource(resources);
        }


        for (TResource tResource : response) {
            List<TResource> resources = new ArrayList<>();
            for (TResource resource : tResource.getTResource()) {
                for (TResource tResource1 : result) {
                    if (tResource1.getParent() == resource.getId()) {
                        resources.add(tResource1);
                    }

                }
                resource.setTResource(resources);
            }

        }
        return response;
    }

    public List<TResource> findMenu() {
        List<TResource> result = tResourceMapper.findAllList();
        List<TResource> response = new ArrayList();
        for (TResource tResource : result) {
            if (tResource.getParent() != null || tResource.getParent() != 0) {
                TResource resource = new TResource();
                BeanUtils.copyProperties(tResource, resource);
                response.add(tResource);
            }
        }
        return response;
    }

    public PageBean<TRole> selectAll(Integer page, Integer rows) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】

        PageHelper.startPage(page, rows);

        List<TRole> select = tRoleMapper.select();//全部商品
        int countNums = tRoleMapper.countItem();            //总记录数
        PageBean<TRole> pageData = new PageBean<>(page, rows, countNums);

        pageData.setRows(select);
        return pageData;
    }

    public List<TRole> selectAllRoles() {
        return tRoleMapper.select();
    }

    public void deleRole(Integer roleId) {
        tRoleMapper.delByKry(roleId);
        roleHasResourceMapper.delByRoleKey(roleId);
        tUserRoleMapper.deleteByRoleId(roleId);
    }
}
