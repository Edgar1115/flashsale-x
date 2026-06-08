package com.flashsale.x.common.exception;

import com.flashsale.x.common.result.ResultCode;
import lombok.Getter;

@Getter // 自动生成getter方法
public class BusinessException extends RuntimeException {
    // RuntimeException：运行时异常，抛出时不需要try-catch

    private final Integer code;         // 业务状态码


    public BusinessException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public BusinessException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
    }

    public BusinessException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}