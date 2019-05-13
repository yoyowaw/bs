package com.youzhihua.bs.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class QpNoticebill implements Serializable {
    private Integer id;

    private Integer staffId;

    private Integer customerId;

    private String customerName;

    private String delegater;

    private String pickaddress;

    private String arrivecity;

    private Date product;

    private Integer num;

    private Double weight;

    private String volume;

    private String remark;

    private String ordertype;

    private String userId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getDelegater() {
        return delegater;
    }

    public void setDelegater(String delegater) {
        this.delegater = delegater == null ? null : delegater.trim();
    }

    public String getPickaddress() {
        return pickaddress;
    }

    public void setPickaddress(String pickaddress) {
        this.pickaddress = pickaddress == null ? null : pickaddress.trim();
    }

    public String getArrivecity() {
        return arrivecity;
    }

    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity == null ? null : arrivecity.trim();
    }

    public Date getProduct() {
        return product;
    }

    public void setProduct(Date product) {
        this.product = product;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume == null ? null : volume.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", staffId=").append(staffId);
        sb.append(", customerId=").append(customerId);
        sb.append(", customerName=").append(customerName);
        sb.append(", delegater=").append(delegater);
        sb.append(", pickaddress=").append(pickaddress);
        sb.append(", arrivecity=").append(arrivecity);
        sb.append(", product=").append(product);
        sb.append(", num=").append(num);
        sb.append(", weight=").append(weight);
        sb.append(", volume=").append(volume);
        sb.append(", remark=").append(remark);
        sb.append(", ordertype=").append(ordertype);
        sb.append(", userId=").append(userId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}