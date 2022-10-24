package com.hdsoft.coremailbridge.dto;

import java.util.List;

public class FeiShuUserCustomAttr {
    private String type;
    private String id;
    private List<FeiShuUserCustomAttrValue> value;

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public List<FeiShuUserCustomAttrValue> getValue() {
        return value;
    }
    public void setValue(List<FeiShuUserCustomAttrValue> value) {
        this.value = value;
    }
}
