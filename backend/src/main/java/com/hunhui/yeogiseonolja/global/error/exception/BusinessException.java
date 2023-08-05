package com.hunhui.yeogiseonolja.global.error.exception;

import com.hunhui.yeogiseonolja.global.error.ErrorCode;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private final ErrorCode code;

    public BusinessException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
