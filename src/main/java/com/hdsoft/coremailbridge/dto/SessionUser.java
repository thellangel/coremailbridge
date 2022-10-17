package com.hdsoft.coremailbridge.dto;

import java.io.Serializable;

public class SessionUser implements Serializable {
    private String mobile;
    private String email;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
