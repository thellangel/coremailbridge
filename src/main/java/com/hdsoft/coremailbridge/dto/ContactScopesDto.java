package com.hdsoft.coremailbridge.dto;

import java.util.List;

public class ContactScopesDto {
    private List<String> department_ids;
    private List<String> user_ids;
    private List<String> group_ids;
    private boolean has_more;
    private String page_token;

    public List<String> getDepartment_ids() {
        return department_ids;
    }

    public void setDepartment_ids(List<String> department_ids) {
        this.department_ids = department_ids;
    }

    public List<String> getUser_ids() {
        return user_ids;
    }

    public void setUser_ids(List<String> user_ids) {
        this.user_ids = user_ids;
    }

    public List<String> getGroup_ids() {
        return group_ids;
    }

    public void setGroup_ids(List<String> group_ids) {
        this.group_ids = group_ids;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public String getPage_token() {
        return page_token;
    }

    public void setPage_token(String page_token) {
        this.page_token = page_token;
    }
}

