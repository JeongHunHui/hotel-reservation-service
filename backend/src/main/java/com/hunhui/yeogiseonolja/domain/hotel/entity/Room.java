package com.hunhui.yeogiseonolja.domain.hotel.entity;

import com.hunhui.yeogiseonolja.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "rooms")
public class Room extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer count;

    @Column(nullable = false)
    private Integer maxPeopleCount;

    @Builder
    public Room(Hotel hotel, String name, Integer price, Integer count, Integer maxPeopleCount) {
        this.hotel = hotel;
        this.name = name;
        this.price = price;
        this.count = count;
        this.maxPeopleCount = maxPeopleCount;
    }
}
