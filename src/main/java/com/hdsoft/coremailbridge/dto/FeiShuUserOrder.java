package com.hdsoft.coremailbridge.dto;


public class FeiShuUserOrder {
    private String department_id;
    private Integer user_order;
    private Integer department_order;

    public String getDepartment_id() {
        return department_id;
    }
    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }
    public Integer getUser_order() {
        return user_order;
    }
    public void setUser_order(Integer user_order) {
        this.user_order = user_order;
    }
    public Integer getDepartment_order() {
        return department_order;
    }
    public void setDepartment_order(Integer department_order) {
        this.department_order = department_order;
    }
}

