package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.MovieDto;
import com.bmt.bookmyticket.model.MovieEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class MovieAdapter {

	public static MovieEntity toEntity(MovieDto movieDto) {

		return MovieEntity.builder()
				.name(movieDto.getName())
				.releaseDate(movieDto.getReleaseDate())
				.imageUrl(movieDto.getImageUrl())
				.build();

	}

	public static MovieDto toDto(MovieEntity movieEntity) {

		return MovieDto.builder()
				.id(movieEntity.getId())
				.name(movieEntity.getName())
				.releaseDate(movieEntity.getReleaseDate())
				.imageUrl(movieEntity.getImageUrl())
				.build();
	}

	public static List<MovieDto> toDto(List<MovieEntity> movieEntities){
		List<MovieDto> movieDtos = new ArrayList<>();

		for (MovieEntity movieEntity : movieEntities) {
			MovieDto movieDto = MovieDto.builder()
					.id(movieEntity.getId())
					.name(movieEntity.getName())
					.releaseDate(movieEntity.getReleaseDate())
					.imageUrl(movieEntity.getImageUrl())
					.build();

			movieDtos.add(movieDto);
		}

		return movieDtos;
	}

}