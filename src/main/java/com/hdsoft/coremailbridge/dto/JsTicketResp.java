package com.hdsoft.coremailbridge.dto;

public class JsTicketResp {
    private int code;
    private String msg;

    private JsTicket data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JsTicket getData() {
        return data;
    }

    public void setData(JsTicket data) {
        this.data = data;
    }


}