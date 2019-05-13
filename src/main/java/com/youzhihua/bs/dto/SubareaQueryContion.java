package com.youzhihua.bs.dto;

import com.youzhihua.bs.dao.entity.Region;

public class SubareaQueryContion {

    private String province;
    private String city;
    private String district;
    private String addresskey;

    private Region region;
    public SubareaQueryContion(String province, String city, String district, String addresskey) {
        this.province = province;
        this.city = city;
        this.district = district;
        this.addresskey = addresskey;
    }

    public SubareaQueryContion() {
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddresskey() {
        return addresskey;
    }

    public void setAddresskey(String addresskey) {
        this.addresskey = addresskey;
    }
}
