package com.youzhihua.bs.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class QpWorkordermanege implements Serializable {
    private Integer id;

    private String arrivecity;

    private String product;

    private Integer num;

    private String floadreqr;

    private String prodtimelimit;

    private String prodtype;

    private String sendername;

    private String senderaddr;

    private String receivername;

    private String receiverphone;

    private String receiveraddr;

    private Integer feeitemun;

    private Double actkweit;

    private String vol;

    private String managercheck;

    private Date updatetime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArrivecity() {
        return arrivecity;
    }

    public void setArrivecity(String arrivecity) {
        this.arrivecity = arrivecity == null ? null : arrivecity.trim();
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product == null ? null : product.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getFloadreqr() {
        return floadreqr;
    }

    public void setFloadreqr(String floadreqr) {
        this.floadreqr = floadreqr == null ? null : floadreqr.trim();
    }

    public String getProdtimelimit() {
        return prodtimelimit;
    }

    public void setProdtimelimit(String prodtimelimit) {
        this.prodtimelimit = prodtimelimit == null ? null : prodtimelimit.trim();
    }

    public String getProdtype() {
        return prodtype;
    }

    public void setProdtype(String prodtype) {
        this.prodtype = prodtype == null ? null : prodtype.trim();
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername == null ? null : sendername.trim();
    }

    public String getSenderaddr() {
        return senderaddr;
    }

    public void setSenderaddr(String senderaddr) {
        this.senderaddr = senderaddr == null ? null : senderaddr.trim();
    }

    public String getReceivername() {
        return receivername;
    }

    public void setReceivername(String receivername) {
        this.receivername = receivername == null ? null : receivername.trim();
    }

    public String getReceiverphone() {
        return receiverphone;
    }

    public void setReceiverphone(String receiverphone) {
        this.receiverphone = receiverphone == null ? null : receiverphone.trim();
    }

    public String getReceiveraddr() {
        return receiveraddr;
    }

    public void setReceiveraddr(String receiveraddr) {
        this.receiveraddr = receiveraddr == null ? null : receiveraddr.trim();
    }

    public Integer getFeeitemun() {
        return feeitemun;
    }

    public void setFeeitemun(Integer feeitemun) {
        this.feeitemun = feeitemun;
    }

    public Double getActkweit() {
        return actkweit;
    }

    public void setActkweit(Double actkweit) {
        this.actkweit = actkweit;
    }

    public String getVol() {
        return vol;
    }

    public void setVol(String vol) {
        this.vol = vol == null ? null : vol.trim();
    }

    public String getManagercheck() {
        return managercheck;
    }

    public void setManagercheck(String managercheck) {
        this.managercheck = managercheck == null ? null : managercheck.trim();
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", arrivecity=").append(arrivecity);
        sb.append(", product=").append(product);
        sb.append(", num=").append(num);
        sb.append(", floadreqr=").append(floadreqr);
        sb.append(", prodtimelimit=").append(prodtimelimit);
        sb.append(", prodtype=").append(prodtype);
        sb.append(", sendername=").append(sendername);
        sb.append(", senderaddr=").append(senderaddr);
        sb.append(", receivername=").append(receivername);
        sb.append(", receiverphone=").append(receiverphone);
        sb.append(", receiveraddr=").append(receiveraddr);
        sb.append(", feeitemun=").append(feeitemun);
        sb.append(", actkweit=").append(actkweit);
        sb.append(", vol=").append(vol);
        sb.append(", managercheck=").append(managercheck);
        sb.append(", updatetime=").append(updatetime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}