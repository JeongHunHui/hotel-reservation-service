package com.hunhui.yeogiseonolja.global.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // global
    INTERNAL_SERVER_ERROR(500, "G00001", "서버 오류"),
    INPUT_INVALID_VALUE(409, "G00002", "잘못된 입력"),

    // hotel
    HOTEL_NOT_FOUND(404, "H00001", "호텔을 찾을 수 없음");

    private final int status;
    private final String code;
    private final String message;
}
