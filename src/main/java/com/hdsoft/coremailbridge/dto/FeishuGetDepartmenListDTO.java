package com.hdsoft.coremailbridge.dto;

import java.util.List;

public class FeishuGetDepartmenListDTO {
    private Boolean has_more;
    private String page_token;
    private List<FeiShuDepartment> items;

    public FeishuGetDepartmenListDTO(FeishuGetDepatmentListData data) {
        this.setHas_more(data.getHas_more());
        this.setItems(data.getItems());
        this.setPage_token(data.getPage_token() == null ? null : data.getPage_token());
    }

    public Boolean getHas_more() {
        return has_more;
    }
    public void setHas_more(Boolean has_more) {
        this.has_more = has_more;
    }
    public String getPage_token() {
        return page_token;
    }
    public void setPage_token(String page_token) {
        this.page_token = page_token;
    }
    public List<FeiShuDepartment> getItems() {
        return items;
    }
    public void setItems(List<FeiShuDepartment> items) {
        this.items = items;
    }

}