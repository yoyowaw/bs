package com.youzhihua.bs.dao.entity;

import java.io.Serializable;

public class Region implements Serializable {
    private String id;

    private String province;

    private String city;

    private String district;

    private String postcode;

    private String shortcode;

    private String citycode;

    private static final long serialVersionUID = 1L;

    public Region(String id, String province, String city, String district, String postcode, String s) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        this.shortcode = shortcode;
        this.citycode = citycode;
    }

    public Region(String province, String city, String district) {
        this.province = province;
        this.city = city;
        this.district = district;
    }

    public Region(String city) {
        this.city = city;
    }

    public Region(String id, String province, String city, String district, String postcode, String shortcode, String citycode) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        this.shortcode = shortcode;
        this.citycode = citycode;
    }

    public Region(String id, String province, String city, String district, String postcode, Object o, Object o1, Object o2) {
        this.id = id;
        this.province = province;
        this.city = city;
        this.district = district;
        this.postcode = postcode;
        this.shortcode = shortcode;
        this.citycode = citycode;
    }

    public Region() {
    }


    public String getName(){
        return province+ city +district;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode == null ? null : shortcode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", postcode=").append(postcode);
        sb.append(", shortcode=").append(shortcode);
        sb.append(", citycode=").append(citycode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}