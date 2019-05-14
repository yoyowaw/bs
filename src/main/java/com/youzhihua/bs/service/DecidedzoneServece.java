package com.youzhihua.bs.service;

import com.github.pagehelper.PageHelper;
import com.youzhihua.bs.dao.DecidedzoneMapper;
import com.youzhihua.bs.dao.StaffMapper;
import com.youzhihua.bs.dao.entity.Decidedzone;
import com.youzhihua.bs.dao.entity.Staff;
import com.youzhihua.bs.request.AddDecideZoneRequest;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DecidedzoneServece {

    @Autowired
    private DecidedzoneMapper mapper;

    @Autowired
    private StaffMapper staffMapper;

    public void add(AddDecideZoneRequest decidedzone) {
        Decidedzone decidedzone1 = new Decidedzone();
        BeanUtils.copyProperties(decidedzone,decidedzone1);
        mapper.insert(decidedzone1);
    }

    public PageBean<Decidedzone> findItemByPage(int page, int rows) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】

        PageHelper.startPage(page, rows);

        List<Decidedzone> allItems = mapper.selectAll();        //全部商品
        for (Decidedzone allItem : allItems) {
            if(allItem.getStaffId()!=null){
                Staff staff = staffMapper.selectByPrimaryKey(allItem.getStaffId());
                allItem.setStaff(staff);
            }
        }
        int countNums = mapper.countItem();            //总记录数
        PageBean<Decidedzone> pageData = new PageBean<>(page, rows, countNums);
        pageData.setRows(allItems);
        return pageData;
    }
}
