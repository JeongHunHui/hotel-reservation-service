package com.hunhui.yeogiseonolja.domain.hotel.entity;

import com.hunhui.yeogiseonolja.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "hotels")
public class Hotel extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detail_region_id", nullable = false)
    private DetailRegion detailRegion;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private Long regionId;

    @Column(nullable = false)
    private String detailRegionName;

    @Column(precision = 2, scale = 1)
    private BigDecimal rating;

    private String content;

    @Builder
    public Hotel(Category category, DetailRegion detailRegion, String name, String address, BigDecimal rating, String content) {
        this.category = category;
        this.detailRegion = detailRegion;
        this.name = name;
        this.address = address;
        this.categoryName = category.getName();
        this.regionId = detailRegion.getRegion().getId();
        this.detailRegionName = detailRegion.getName();
        this.rating = rating;
        this.content = content;
    }
}
