package com.youzhihua.bs.service;

import com.github.pagehelper.PageHelper;
import com.youzhihua.bs.dao.QpNoticebillMapper;
import com.youzhihua.bs.dao.QpWorkbillMapper;
import com.youzhihua.bs.dao.QpWorkordermanegeMapper;
import com.youzhihua.bs.dao.StaffMapper;
import com.youzhihua.bs.dao.entity.QpNoticebill;
import com.youzhihua.bs.dao.entity.QpWorkbill;
import com.youzhihua.bs.dao.entity.QpWorkordermanege;
import com.youzhihua.bs.dao.entity.Staff;
import com.youzhihua.bs.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeBillService {

    @Autowired
    private QpNoticebillMapper mapper;

    @Autowired
    private QpWorkordermanegeMapper qpWorkbillMapper;

    @Autowired
    private StaffMapper staffMapper;

    public void save(QpNoticebill noticebill) {
        mapper.insert(noticebill);
    }

    public void addwork(QpWorkordermanege qpWorkbill) {

        qpWorkbillMapper.insert(qpWorkbill);
    }

    public PageBean<QpNoticebill> select(Integer page, Integer rows) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】

        PageHelper.startPage(page, rows);

        List<QpNoticebill> allItems = mapper.selectAll();        //全部商品
        List<QpNoticebill> item = new ArrayList<>();
        for (QpNoticebill allItem : allItems) {
            Staff staff = staffMapper.selectByPrimaryKey(String.valueOf(allItem.getStaffId()));
            if(staff != null){
                allItem.setStaffName(staff.getName());
                item.add(allItem);
            }
        }
        int countNums = mapper.countItem();            //总记录数
        PageBean<QpNoticebill> pageData = new PageBean<>(page, rows, countNums);
        pageData.setRows(item);
        return pageData;
    }

    public void del(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }
}
