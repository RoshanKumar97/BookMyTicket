package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.MovieDto;
import com.bmt.bookmyticket.model.MovieEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MovieAdapter {

	public static MovieEntity toEntity(MovieDto movieDto) {

		return MovieEntity.builder()
				.name(movieDto.getName())
				.build();

	}

	public static MovieDto toDto(MovieEntity movieEntity) {

		return MovieDto.builder()
				.id(movieEntity.getId())
				.name(movieEntity.getName())
				.build();
	}

}