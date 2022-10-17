package com.hdsoft.coremailbridge.dto;

public class FeiShuResponse<T> extends FeiShuBaseResponse {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
