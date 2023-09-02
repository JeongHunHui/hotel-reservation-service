package com.hunhui.yeogiseonolja.domain.hotel.service;

import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelResponse;
import com.hunhui.yeogiseonolja.domain.hotel.entity.Hotel;
import com.hunhui.yeogiseonolja.domain.hotel.exception.HotelNotFoundException;
import com.hunhui.yeogiseonolja.domain.hotel.mapper.HotelMapper;
import com.hunhui.yeogiseonolja.domain.hotel.repository.HotelRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelResponse getHotelById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(HotelNotFoundException::new);
        return hotelMapper.toDto(hotel);
    }
}
