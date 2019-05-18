package com.youzhihua.bs.service;

import com.github.pagehelper.PageHelper;
import com.youzhihua.bs.dao.StaffMapper;
import com.youzhihua.bs.dao.entity.Staff;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StaffService {

    @Autowired
    private StaffMapper staffMapper;

    public void save(Staff staff) {
        staffMapper.insert(staff);
    }


    public PageBean<Staff> findItemByPage(int currentPage, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】

        PageHelper.startPage(currentPage, pageSize);

        List<Staff> allItems = staffMapper.selectAll();        //全部商品
        int countNums = staffMapper.countItem();            //总记录数
        PageBean<Staff> pageData = new PageBean<>(currentPage, pageSize, countNums);
        pageData.setRows(allItems);
        return pageData;
    }

    public void deleteStaff(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            staffMapper.deleteById(s);
        }
    }

    public void edit(Staff staff) {
        staffMapper.updateByPrimaryKey(staff);
    }

    public List<Staff> findAll() {
        List<Staff> staff = staffMapper.selectAll();
        return staff;
    }
}
