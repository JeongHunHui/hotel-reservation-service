package com.hunhui.yeogiseonolja.domain.hotel.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SearchResultSortType {
    DEFAULT("default", true),
    MIN_PRICE("minPrice", true),
    MAX_PRICE("maxPrice", false),
    RATING("rating", false);

    private String sortType;
    private Boolean isAsc;
}
