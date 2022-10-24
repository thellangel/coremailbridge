package com.hdsoft.coremailbridge.dto;


public class FeiShuUserCustomAttrValue {
    private String text;
    private String url;
    private String pc_url;
    private String option_value;
    private String name;
    private String picture_url;
    private FeiShuUserCustomAttrValueGenericUser generic_user;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getPc_url() {
        return pc_url;
    }
    public void setPc_url(String pc_url) {
        this.pc_url = pc_url;
    }
    public String getOption_value() {
        return option_value;
    }
    public void setOption_value(String option_value) {
        this.option_value = option_value;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPicture_url() {
        return picture_url;
    }
    public void setPicture_url(String picture_url) {
        this.picture_url = picture_url;
    }
    public FeiShuUserCustomAttrValueGenericUser getGeneric_user() {
        return generic_user;
    }
    public void setGeneric_user(FeiShuUserCustomAttrValueGenericUser generic_user) {
        this.generic_user = generic_user;
    }
}

