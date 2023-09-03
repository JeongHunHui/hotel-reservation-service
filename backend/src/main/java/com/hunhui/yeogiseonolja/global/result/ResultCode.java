package com.hunhui.yeogiseonolja.global.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    // 도메인 별로 나눠서 관리
    // hotel
    HOTEL_FIND_SUCCESS("H00001", "호텔 조회 성공"),
    HOTEL_SEARCH_SUCCESS("H00002", "호텔 검색 성공"),
    ;

    private final String code;
    private final String message;
}
