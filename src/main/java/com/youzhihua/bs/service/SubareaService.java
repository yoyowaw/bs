package com.youzhihua.bs.service;

import com.github.pagehelper.PageHelper;
import com.youzhihua.bs.dao.DecidedzoneMapper;
import com.youzhihua.bs.dao.RegionMapper;
import com.youzhihua.bs.dao.SubareaMapper;
import com.youzhihua.bs.dao.entity.Decidedzone;
import com.youzhihua.bs.dao.entity.Region;
import com.youzhihua.bs.dao.entity.Subarea;
import com.youzhihua.bs.dto.SubareaQueryContion;
import com.youzhihua.bs.utils.PageBean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubareaService {

    @Autowired
    private SubareaMapper subareaMapper;

    @Autowired
    private RegionMapper regionMapper;

    @Autowired
    private DecidedzoneMapper decidedzoneMapper;



    public void save(Subarea subarea) {
        subareaMapper.insert(subarea);
    }

    public PageBean<Subarea> findAll(int page, int rows, SubareaQueryContion subareaQueryContion) {
        PageHelper.startPage(page, rows);

        List<Subarea> allItems = subareaMapper.selectAll();        //全部商品
        allItems.forEach((e) -> {
            Region region = regionMapper.selectByPrimaryKey(e.getRegionId());
            e.setRegion(region);
        });

        if (subareaQueryContion != null) {
            String addresskey = subareaQueryContion.getAddresskey();
            if (StringUtils.isNotBlank(addresskey)) {
            }
            String city = subareaQueryContion.getCity();
            if (StringUtils.isNotBlank(addresskey)) {
                allItems = allItems.stream().filter((e) ->
                        e.getRegion().getCity().equals(city)
                ).collect(Collectors.toList());
            }
            String district = subareaQueryContion.getDistrict();
            if (StringUtils.isNotBlank(district)) {
                allItems = allItems.stream().filter((e) ->
                        e.getRegion().getDistrict().equals(district)
                ).collect(Collectors.toList());
            }
            String province = subareaQueryContion.getProvince();
            if (StringUtils.isNotBlank(province)) {
                allItems = allItems.stream().filter((e) ->
                        e.getRegion().getProvince().equals(province)
                ).collect(Collectors.toList());
            }

        }
        int countNums = subareaMapper.countItem();            //总记录数
        PageBean<Subarea> pageData = new PageBean<>(page, rows, countNums);
        pageData.setRows(allItems);

        return pageData;

    }

    public List<Subarea> queryAll() {
        return subareaMapper.selectAll();
    }

    public List<Subarea> findList(String id) {
        List<Subarea> result = new ArrayList<>();
        Decidedzone decidedzone = decidedzoneMapper.selectByPrimaryKey(id);
        if (decidedzone != null) {
            if(StringUtils.isNotBlank(decidedzone.getSubareaid())){
                String[] split = decidedzone.getSubareaid().split(",");
                for (String s : split) {
                    Subarea subarea = subareaMapper.selectByPrimaryKey(s);
                    if(subarea.getRegionId() != null){
                        Region region = regionMapper.selectByPrimaryKey(subarea.getRegionId());
                        subarea.setRegion(region);

                    }
                    result.add(subarea);
                }
            }
        }

        return result;
    }
}
