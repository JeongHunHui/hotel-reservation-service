package com.hunhui.yeogiseonolja.domain.hotel.controller;

import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelResponse;
import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelSearchRequest;
import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelSearchResponse;
import com.hunhui.yeogiseonolja.domain.hotel.service.HotelService;
import com.hunhui.yeogiseonolja.global.result.ResultCode;
import com.hunhui.yeogiseonolja.global.result.ResultResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/hotels")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelController {
    private final HotelService hotelService;

    @GetMapping("{id}")
    public ResponseEntity<ResultResponse> findHotelById(@PathVariable Long id) {
        HotelResponse hotelResponse = hotelService.getHotelById(id);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.HOTEL_FIND_SUCCESS, hotelResponse));
    }

    @GetMapping("/search")
    public ResponseEntity<ResultResponse> searchHotel(@ModelAttribute HotelSearchRequest searchRequest) {
        List<HotelSearchResponse> hotelSearchResponses = hotelService.searchHotel(searchRequest);
        return ResponseEntity.ok(ResultResponse.of(ResultCode.HOTEL_SEARCH_SUCCESS, hotelSearchResponses));
    }
}
