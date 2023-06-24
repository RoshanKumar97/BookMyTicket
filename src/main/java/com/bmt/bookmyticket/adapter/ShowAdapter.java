package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.ShowDto;
import com.bmt.bookmyticket.model.ShowEntity;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ShowAdapter {

	public static List<ShowDto> toDto(List<ShowEntity> showEntities) {

		if (!CollectionUtils.isEmpty(showEntities)) {
			return showEntities.stream().map(ShowAdapter::toDto).collect(Collectors.toList());
		}

		return new ArrayList<>();
	}

	public static ShowDto toDto(ShowEntity showEntity) {

		return ShowDto.builder()
				.id(showEntity.getId())
				.showDate(showEntity.getShowDate())
				.showTime(showEntity.getShowTime())
				.rateMultiplier(showEntity.getRateMultiplier())
				.movie(MovieAdapter.toDto(showEntity.getMovie()))
				.theatre(TheaterAdapter.toDto(showEntity.getTheater()))
				.seats(ShowSeatsAdapter.toDto(showEntity.getSeats()))
				.createdAt(showEntity.getCreatedAt())
				.updatedAt(showEntity.getUpdatedAt())
				.build();

	}

	public static ShowEntity toEntity(ShowDto showDto) {

		return ShowEntity.builder()
				.showDate(showDto.getShowDate())
				.showTime(showDto.getShowTime())
				.rateMultiplier(showDto.getRateMultiplier())
				.build();

	}

}