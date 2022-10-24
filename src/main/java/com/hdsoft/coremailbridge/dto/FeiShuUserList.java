package com.hdsoft.coremailbridge.dto;

import java.util.List;

public class FeiShuUserList {
    private Boolean has_more;
    private String page_token;
    private List<FeiShuUser> items;

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

    public List<FeiShuUser> getItems() {
        return items;
    }

    public void setItems(List<FeiShuUser> items) {
        this.items = items;
    }
}
