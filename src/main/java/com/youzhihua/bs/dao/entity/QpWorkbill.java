package com.youzhihua.bs.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class QpWorkbill implements Serializable {
    private Integer id;

    private Integer noticebillId;

    private String type;

    private String pickstate;

    private Date buildtime;

    private Integer attachbilltimes;

    private String remark;

    private Integer staffId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoticebillId() {
        return noticebillId;
    }

    public void setNoticebillId(Integer noticebillId) {
        this.noticebillId = noticebillId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getPickstate() {
        return pickstate;
    }

    public void setPickstate(String pickstate) {
        this.pickstate = pickstate == null ? null : pickstate.trim();
    }

    public Date getBuildtime() {
        return buildtime;
    }

    public void setBuildtime(Date buildtime) {
        this.buildtime = buildtime;
    }

    public Integer getAttachbilltimes() {
        return attachbilltimes;
    }

    public void setAttachbilltimes(Integer attachbilltimes) {
        this.attachbilltimes = attachbilltimes;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", noticebillId=").append(noticebillId);
        sb.append(", type=").append(type);
        sb.append(", pickstate=").append(pickstate);
        sb.append(", buildtime=").append(buildtime);
        sb.append(", attachbilltimes=").append(attachbilltimes);
        sb.append(", remark=").append(remark);
        sb.append(", staffId=").append(staffId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}