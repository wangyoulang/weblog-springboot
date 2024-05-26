package com.quanxiaoha.weblog.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum {
    // ================通用异常状态码=================
    SYSTEM_ERROR("10000", "出错了，后台小哥正在努力修复……"),

    // ================业务异常状态码
    PRODUCT_NOT_FOUND("20000", "该产品不存在");

    private String errorCode;
    private String errorMessage;
}
