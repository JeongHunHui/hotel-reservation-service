package com.hunhui.yeogiseonolja.domain.hotel.repository;

import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelSearchResponse;
import com.hunhui.yeogiseonolja.domain.hotel.entity.SearchResultSortType;

import java.time.LocalDate;
import java.util.List;

public interface HotelRepositoryCustom {
  List<HotelSearchResponse> findHotelsByCriteria(
          LocalDate startDate,
          LocalDate endDate,
          Long detailRegionId,
          Long categoryId,
          Integer minPrice,
          Integer maxPrice,
          Integer maxPeopleCount,
          Integer limit,
          Integer offset,
          SearchResultSortType sortType);
}
