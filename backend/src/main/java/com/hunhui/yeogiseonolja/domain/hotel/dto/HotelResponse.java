package com.hunhui.yeogiseonolja.domain.hotel.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelResponse {
    private String name;
    private String address;
    private String category;
    private String detailRegion;
    private BigDecimal rating;
    private String content;
    private LocalDateTime createdAt;
}
