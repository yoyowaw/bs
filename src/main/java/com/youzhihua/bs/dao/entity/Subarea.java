package com.youzhihua.bs.dao.entity;

import java.io.Serializable;

public class Subarea implements Serializable {
    private String id;

    private String decidezoneId;

    private String regionId;

    private String addresskey;

    public Region getRegion() {
        return region;
    }

    public String getSubareaid(){
        return id;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    private Region region;

    private String startnum;

    private String endnum;

    private String single;

    private String position;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDecidezoneId() {
        return decidezoneId;
    }

    public void setDecidezoneId(String decidezoneId) {
        this.decidezoneId = decidezoneId == null ? null : decidezoneId.trim();
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId == null ? null : regionId.trim();
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey == null ? null : addresskey.trim();
    }

    public String getStartnum() {
        return startnum;
    }

    public void setStartnum(String startnum) {
        this.startnum = startnum == null ? null : startnum.trim();
    }

    public String getEndnum() {
        return endnum;
    }

    public void setEndnum(String endnum) {
        this.endnum = endnum == null ? null : endnum.trim();
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single == null ? null : single.trim();
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", decidezoneId=").append(decidezoneId);
        sb.append(", regionId=").append(regionId);
        sb.append(", addresskey=").append(addresskey);
        sb.append(", startnum=").append(startnum);
        sb.append(", endnum=").append(endnum);
        sb.append(", single=").append(single);
        sb.append(", position=").append(position);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}