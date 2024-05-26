package com.quanxiaoha.weblog.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @program: weblog-springboot
 * @description: 业务异常类
 * @author: wangyoulang
 * @create: 2024-05-26 16:30
 **/
@Data
@AllArgsConstructor
public class BizException extends RuntimeException{
    private String errorCode;
    private String errorMessage;
}
