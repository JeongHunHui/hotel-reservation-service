package com.hunhui.yeogiseonolja.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // global
    INTERNAL_SERVER_ERROR(500, "G00001", "서버 오류"),
    INPUT_INVALID_VALUE(409, "G00002", "잘못된 입력");

    private final int status;
    private final String code;
    private final String message;
}
