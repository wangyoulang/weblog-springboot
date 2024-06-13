package com.quanxiaoha.weblog.common.enums;

import com.quanxiaoha.weblog.common.exception.BaseExceptionInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseCodeEnum implements BaseExceptionInterface {
    // ================通用异常状态码=================
    SYSTEM_ERROR("10000", "出错了，后台小哥正在努力修复……"),

    // ================业务异常状态码=================
    PRODUCT_NOT_FOUND("20000", "该产品不存在"),

    // =================参数校验异常码=================
    PARAM_NOT_VALID("10001", "参数错误"),

    LOGIN_FAIL("20000", "登录失败"),

    USER_OR_PASSWORD_ERROR("20002", "用户名或密码错误");

    private String errorCode;
    private String errorMessage;
}
