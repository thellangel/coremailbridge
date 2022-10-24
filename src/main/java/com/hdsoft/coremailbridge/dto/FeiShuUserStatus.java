package com.hdsoft.coremailbridge.dto;

public class FeiShuUserStatus {
    private Boolean is_frozen;
    private Boolean is_resigned;
    private Boolean is_activated;

    public Boolean getIs_frozen() {
        return is_frozen;
    }
    public void setIs_frozen(Boolean is_frozen) {
        this.is_frozen = is_frozen;
    }
    public Boolean getIs_resigned() {
        return is_resigned;
    }
    public void setIs_resigned(Boolean is_resigned) {
        this.is_resigned = is_resigned;
    }
    public Boolean getIs_activated() {
        return is_activated;
    }
    public void setIs_activated(Boolean is_activated) {
        this.is_activated = is_activated;
    }
}
