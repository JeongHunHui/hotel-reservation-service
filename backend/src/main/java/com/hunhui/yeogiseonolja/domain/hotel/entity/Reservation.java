package com.hunhui.yeogiseonolja.domain.hotel.entity;

import com.hunhui.yeogiseonolja.domain.user.entity.User;
import com.hunhui.yeogiseonolja.global.entity.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "reservations")
public class Reservation extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "finish_date", nullable = false)
    private LocalDate finishDate;

    @Builder
    public Reservation(User user, Room room, LocalDate startDate, LocalDate finishDate) {
        this.user = user;
        this.room = room;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }
}
