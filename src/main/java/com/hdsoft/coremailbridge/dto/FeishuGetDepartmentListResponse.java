package com.hdsoft.coremailbridge.dto;

public class FeishuGetDepartmentListResponse extends FeiShuResponse<FeishuGetDepatmentListData>{
    public FeishuGetDepartmenListDTO transeData() {
        FeishuGetDepatmentListData data = this.getData();
        return new FeishuGetDepartmenListDTO(data);
    }
}