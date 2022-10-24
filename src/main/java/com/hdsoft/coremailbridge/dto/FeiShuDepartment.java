package com.hdsoft.coremailbridge.dto;

import java.util.List;

public class FeiShuDepartment {
    private String name;
    private FeiShuDepartmentI18nName i18n_name;
    private String parent_department_id;
    private String department_id;
    private String open_department_id;
    private String leader_user_id;
    private String chat_id;
    private String order;
    private List<String> unit_ids;
    private Integer member_count;
    private FeiShuDepartmentStatus status;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public FeiShuDepartmentI18nName getI18n_name() {
        return i18n_name;
    }
    public void setI18n_name(FeiShuDepartmentI18nName i18n_name) {
        this.i18n_name = i18n_name;
    }
    public String getParent_department_id() {
        return parent_department_id;
    }
    public void setParent_department_id(String parent_department_id) {
        this.parent_department_id = parent_department_id;
    }
    public String getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }
    public String getOpen_department_id() {
        return open_department_id;
    }
    public void setOpen_department_id(String open_department_id) {
        this.open_department_id = open_department_id;
    }
    public String getLeader_user_id() {
        return leader_user_id;
    }
    public void setLeader_user_id(String leader_user_id) {
        this.leader_user_id = leader_user_id;
    }
    public String getChat_id() {
        return chat_id;
    }
    public void setChat_id(String chat_id) {
        this.chat_id = chat_id;
    }
    public String getOrder() {
        return order;
    }
    public void setOrder(String order) {
        this.order = order;
    }
    public List<String> getUnit_ids() {
        return unit_ids;
    }
    public void setUnit_ids(List<String> unit_ids) {
        this.unit_ids = unit_ids;
    }
    public Integer getMember_count() {
        return member_count;
    }
    public void setMember_count(Integer member_count) {
        this.member_count = member_count;
    }
    public FeiShuDepartmentStatus getStatus() {
        return status;
    }
    public void setStatus(FeiShuDepartmentStatus status) {
        this.status = status;
    }
}