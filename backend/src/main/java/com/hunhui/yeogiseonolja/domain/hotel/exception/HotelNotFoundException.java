package com.hunhui.yeogiseonolja.domain.hotel.exception;

import com.hunhui.yeogiseonolja.global.error.exception.BusinessException;

import static com.hunhui.yeogiseonolja.global.error.ErrorCode.HOTEL_NOT_FOUND;

public class HotelNotFoundException extends BusinessException {
    public HotelNotFoundException() {
        super(HOTEL_NOT_FOUND);
    }
}
