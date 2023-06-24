package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.ShowSeatsDto;
import com.bmt.bookmyticket.model.ShowSeatsEntity;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ShowSeatsAdapter {

	public static List<ShowSeatsDto> toDto(List<ShowSeatsEntity> seatsEntities) {

		if (!CollectionUtils.isEmpty(seatsEntities)) {
			return seatsEntities.stream().map(ShowSeatsAdapter::toDto).collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	public static ShowSeatsDto toDto(ShowSeatsEntity seatsEntity) {

		return ShowSeatsDto.builder()
				.id(seatsEntity.getId())
				.seatNumber(seatsEntity.getSeatNumber())
				.rate(seatsEntity.getRate())
				.seatType(seatsEntity.getSeatType())
				.booked(seatsEntity.isBooked())
				.bookedAt(seatsEntity.getBookedAt())
				.build();

	}

}