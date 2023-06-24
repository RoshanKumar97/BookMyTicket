package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.TheaterDto;
import com.bmt.bookmyticket.model.TheaterEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TheaterAdapter {

	public static TheaterEntity toEntity(TheaterDto theaterDto) {

		return TheaterEntity.builder()
				.name(theaterDto.getName())
				.city(theaterDto.getCity())
				.address(theaterDto.getAddress())
				.build();
	}

	public static TheaterDto toDto(TheaterEntity theaterEntity) {

		return TheaterDto.builder()
				.id(theaterEntity.getId())
				.name(theaterEntity.getName())
				.city(theaterEntity.getCity())
				.address(theaterEntity.getAddress())
				.build();
	}

}