package com.youzhihua.bs.service;

import com.youzhihua.bs.dao.QpNoticebillMapper;
import com.youzhihua.bs.dao.QpWorkbillMapper;
import com.youzhihua.bs.dao.QpWorkordermanegeMapper;
import com.youzhihua.bs.dao.entity.QpNoticebill;
import com.youzhihua.bs.dao.entity.QpWorkbill;
import com.youzhihua.bs.dao.entity.QpWorkordermanege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeBillService {

    @Autowired
    private QpNoticebillMapper mapper;

    @Autowired
    private QpWorkordermanegeMapper qpWorkbillMapper;

    public void save(QpNoticebill noticebill) {
        mapper.insert(noticebill);
    }

    public void addwork(QpWorkordermanege qpWorkbill) {

        qpWorkbillMapper.insert(qpWorkbill);
    }
}
