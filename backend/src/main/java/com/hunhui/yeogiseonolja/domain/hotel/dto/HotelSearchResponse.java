package com.hunhui.yeogiseonolja.domain.hotel.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelSearchResponse {
    private Long id;
    private String hotelName;
    private String address;
    private String detailRegionName;
    private String categoryName;
    private Integer minPrice;
    private BigDecimal rating;
}
