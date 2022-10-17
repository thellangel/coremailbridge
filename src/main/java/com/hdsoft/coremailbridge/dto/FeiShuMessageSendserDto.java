package com.hdsoft.coremailbridge.dto;

public class FeiShuMessageSendserDto {
    private String id;
    private String id_type;
    private String sender_type;
    private String tenant_key;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getSender_type() {
        return sender_type;
    }

    public void setSender_type(String sender_type) {
        this.sender_type = sender_type;
    }

    public String getTenant_key() {
        return tenant_key;
    }

    public void setTenant_key(String tenant_key) {
        this.tenant_key = tenant_key;
    }
}
