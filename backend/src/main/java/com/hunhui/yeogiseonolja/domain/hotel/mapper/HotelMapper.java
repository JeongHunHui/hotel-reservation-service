package com.hunhui.yeogiseonolja.domain.hotel.mapper;

import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelResponse;
import com.hunhui.yeogiseonolja.domain.hotel.entity.Hotel;
import org.springframework.stereotype.Component;

@Component
public class HotelMapper {
    public HotelResponse toDto(Hotel hotel) {
        HotelResponse hotelResponse =
                HotelResponse.builder()
                        .name(hotel.getName())
                        .address(hotel.getAddress())
                        .category(hotel.getCategory().getName())
                        .detailRegion(hotel.getDetailRegionName())
                        .rating(hotel.getRating())
                        .content(hotel.getContent())
                        .createdAt(hotel.getCreatedAt())
                        .build();
        return hotelResponse;
    }
}
