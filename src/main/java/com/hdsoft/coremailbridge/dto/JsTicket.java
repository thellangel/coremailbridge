package com.hdsoft.coremailbridge.dto;

public class JsTicket {

    private String ticket;
    private int expire_in;

    public String getTicket() {
        return ticket;
    }
    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
    public int getExpire_in() {
        return expire_in;
    }
    public void setExpire_in(int expire_in) {
        this.expire_in = expire_in;
    }
}