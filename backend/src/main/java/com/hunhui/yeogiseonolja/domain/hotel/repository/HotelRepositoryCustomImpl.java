package com.hunhui.yeogiseonolja.domain.hotel.repository;

import com.hunhui.yeogiseonolja.domain.hotel.dto.HotelSearchResponse;
import com.hunhui.yeogiseonolja.domain.hotel.entity.QHotel;
import com.hunhui.yeogiseonolja.domain.hotel.entity.QReservation;
import com.hunhui.yeogiseonolja.domain.hotel.entity.QRoom;
import com.hunhui.yeogiseonolja.domain.hotel.entity.SearchResultSortType;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.Coalesce;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static com.querydsl.core.types.ExpressionUtils.count;

@Repository
@RequiredArgsConstructor
public class HotelRepositoryCustomImpl implements HotelRepositoryCustom {
  QHotel hotel = QHotel.hotel;
  QRoom room = QRoom.room;
  QReservation reservation = QReservation.reservation;

  private final JPAQueryFactory queryFactory;

  @Override
  public List<HotelSearchResponse> findHotelsByCriteria(
          LocalDate startDate,
          LocalDate endDate,
          Long detailRegionId,
          Long categoryId,
          Integer minPrice,
          Integer maxPrice,
          Integer maxPeopleCount,
          Integer limit,
          Integer offset,
          SearchResultSortType sortType) {

    // 이용이 가능한 객실을 찾는 서브쿼리
    JPAQuery<Long> availableRoomsSubquery = getAvailableRoomsQuery(startDate,endDate,detailRegionId,categoryId,maxPeopleCount,minPrice,maxPrice);

    // 메인 쿼리
    List<Tuple> results = queryFactory
            .select(hotel.id, hotel.name, hotel.address, hotel.detailRegionName, hotel.categoryName, room.price.min(), hotel.rating)
            .from(hotel)
            .join(room).on(hotel.id.eq(room.hotel.id)
                    .and(room.id.in(availableRoomsSubquery)))
            .groupBy(hotel.id)
            .orderBy(getOrderByExpression(sortType))
            .limit(limit)
            .offset(offset)
            .fetch();

    // 결과를 DTO로 변환
    return results.stream().map(tuple ->
            HotelSearchResponse.builder()
                    .id(tuple.get(hotel.id))
                    .hotelName(tuple.get(hotel.name))
                    .address(tuple.get(hotel.address))
                    .detailRegionName(tuple.get(hotel.detailRegionName))
                    .categoryName(tuple.get(hotel.categoryName))
                    .minPrice(tuple.get(room.price.min()))
                    .rating(tuple.get(hotel.rating))
                    .build()
    ).collect(Collectors.toList());
  }



  private JPAQuery<Long> getAvailableRoomsQuery(LocalDate startDate, LocalDate endDate, Long detailRegionId, Long categoryId, Integer maxPeopleCount, Integer minPrice, Integer maxPrice) {
    BooleanBuilder dynamicConditions = new BooleanBuilder();

    if (minPrice != null) {
      dynamicConditions.and(room.price.goe(minPrice));
    }

    if (maxPrice != null) {
      dynamicConditions.and(room.price.loe(maxPrice));
    }

    return queryFactory
            .select(room.id)
            .from(room)
            .join(room.hotel, hotel)
            .leftJoin(room.reservations, reservation)
            .on(reservation.startDate.lt(startDate)
                    .and(reservation.finishDate.gt(endDate)))
            .where(hotel.detailRegion.id.eq(detailRegionId)
                    .and(hotel.category.id.eq(categoryId))
                    .and(room.maxPeopleCount.goe(maxPeopleCount))
                    .and(dynamicConditions))
            .groupBy(room.id, room.count)
            .having(room.count.gt(
                    new Coalesce<Long>().add(count(reservation.id)).add(0L)
            ));
  }


  private OrderSpecifier<?> getOrderByExpression(SearchResultSortType sortType) {
    Boolean isAsc = sortType.getIsAsc();
    switch (sortType) {
      case MIN_PRICE:
        return isAsc ? QRoom.room.price.asc() : QRoom.room.price.desc();
      case RATING:
        return isAsc ? QHotel.hotel.rating.asc() : QHotel.hotel.rating.desc();
      case MAX_PRICE:
        return isAsc ? QRoom.room.price.desc() : QRoom.room.price.asc();
      default:
        return QHotel.hotel.id.asc();
    }
  }
}
