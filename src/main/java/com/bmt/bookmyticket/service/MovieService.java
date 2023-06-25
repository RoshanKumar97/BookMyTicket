package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.MovieDto;
import com.bmt.bookmyticket.model.MovieEntity;

import java.util.List;

public interface MovieService {

	MovieDto addMovie(MovieDto movieDto);

	MovieDto getMovie(long id);

	List<MovieDto> getAllMovies();
}