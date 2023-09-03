package com.hunhui.yeogiseonolja.domain.hotel.dto;

import com.hunhui.yeogiseonolja.domain.hotel.entity.SearchResultSortType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HotelSearchRequest {
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate startDate;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private LocalDate endDate;
  private Long detailRegionId;
  private Long categoryId;
  private Integer minPrice;
  private Integer maxPrice;
  private Integer maxPeopleCount;
  private Integer limit;
  private Integer offset;
  private SearchResultSortType sortType;
}
