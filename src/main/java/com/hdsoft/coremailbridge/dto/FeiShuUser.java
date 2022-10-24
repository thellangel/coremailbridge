package com.hdsoft.coremailbridge.dto;

import java.util.List;

public class FeiShuUser {
    private String union_id;
    private String open_id;
    private String user_id;
    private String name;
    private String en_name;
    private String email;
    private String mobile;
    private Boolean mobile_visible;
    private Integer gender;
    private FeiShuAvatar avatar;
    private FeiShuUserStatus status;
    private List<String> department_ids;
    private String leader_user_id;
    private String city;
    private String country;
    private String work_station;
    private Integer join_time;
    private Boolean is_tenant_manager;
    private String employee_no;
    private Integer employee_type;
    private List<FeiShuUserOrder> orders;
    private List<FeiShuUserCustomAttr> custom_attrs;
    private String enterprise_email;
    private String job_title;
    public String getUnion_id() {
        return union_id;
    }
    public void setUnion_id(String union_id) {
        this.union_id = union_id;
    }
    public String getOpen_id() {
        return open_id;
    }
    public void setOpen_id(String open_id) {
        this.open_id = open_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public void setUser_id(String user_id) {
        this.user_id = user_id;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public Boolean getMobile_visible() {
        return mobile_visible;
    }
    public void setMobile_visible(Boolean mobile_visible) {
        this.mobile_visible = mobile_visible;
    }
    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }
    public FeiShuUserStatus getStatus() {
        return status;
    }
    public void setStatus(FeiShuUserStatus status) {
        this.status = status;
    }
    public List<String> getDepartment_ids() {
        return department_ids;
    }
    public void setDepartment_ids(List<String> department_ids) {
        this.department_ids = department_ids;
    }
    public String getLeader_user_id() {
        return leader_user_id;
    }
    public void setLeader_user_id(String leader_user_id) {
        this.leader_user_id = leader_user_id;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getWork_station() {
        return work_station;
    }
    public void setWork_station(String work_station) {
        this.work_station = work_station;
    }
    public Integer getJoin_time() {
        return join_time;
    }
    public void setJoin_time(Integer join_time) {
        this.join_time = join_time;
    }
    public Boolean getIs_tenant_manager() {
        return is_tenant_manager;
    }
    public void setIs_tenant_manager(Boolean is_tenant_manager) {
        this.is_tenant_manager = is_tenant_manager;
    }
    public String getEmployee_no() {
        return employee_no;
    }
    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }
    public Integer getEmployee_type() {
        return employee_type;
    }
    public void setEmployee_type(Integer employee_type) {
        this.employee_type = employee_type;
    }
    public List<FeiShuUserOrder> getOrders() {
        return orders;
    }
    public void setOrders(List<FeiShuUserOrder> orders) {
        this.orders = orders;
    }
    public List<FeiShuUserCustomAttr> getCustom_attrs() {
        return custom_attrs;
    }
    public void setCustom_attrs(List<FeiShuUserCustomAttr> custom_attrs) {
        this.custom_attrs = custom_attrs;
    }
    public String getEnterprise_email() {
        return enterprise_email;
    }
    public void setEnterprise_email(String enterprise_email) {
        this.enterprise_email = enterprise_email;
    }
    public String getJob_title() {
        return job_title;
    }
    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

}
