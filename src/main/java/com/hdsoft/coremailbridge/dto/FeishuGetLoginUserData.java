package com.hdsoft.coremailbridge.dto;

public class FeishuGetLoginUserData {
    private String access_token;
    private String token_type;
    private Integer expires_in;
    private String name;
    private String en_name;
    private String avatar_url;
    private String avatar_thumb;
    private String avatar_middle;
    private String avatar_big;
    private String email;
    private String user_id;
    private String mobile;
    private String tenant_key;
    private Integer refreshi_expires_in;
    private String refresh_token;
    private String open_id;
    private String union_id;

    public String getOpen_id() {
        return open_id;
    }
    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }
    public String getUnion_id() {
        return union_id;
    }
    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }
    public String getAccess_token() {
        return access_token;
    }
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    public String getToken_type() {
        return token_type;
    }
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
    public Integer getExpires_in() {
        return expires_in;
    }
    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEn_name() {
        return en_name;
    }
    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }
    public String getAvatar_url() {
        return avatar_url;
    }
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    public String getAvatar_thumb() {
        return avatar_thumb;
    }
    public void setAvatar_thumb(String avatar_thumb) {
        this.avatar_thumb = avatar_thumb;
    }
    public String getAvatar_middle() {
        return avatar_middle;
    }
    public void setAvatar_middle(String avatar_middle) {
        this.avatar_middle = avatar_middle;
    }
    public String getAvatar_big() {
        return avatar_big;
    }
    public void setAvatar_big(String avatar_big) {
        this.avatar_big = avatar_big;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public String getTenant_key() {
        return tenant_key;
    }
    public void setTenant_key(String tenant_key) {
        this.tenant_key = tenant_key;
    }
    public Integer getRefreshi_expires_in() {
        return refreshi_expires_in;
    }
    public void setRefreshi_expires_in(Integer refreshi_expires_in) {
        this.refreshi_expires_in = refreshi_expires_in;
    }
    public String getRefresh_token() {
        return refresh_token;
    }
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
