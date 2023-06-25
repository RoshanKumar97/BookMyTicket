package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.MovieDto;

public interface MovieService {

	MovieDto addMovie(MovieDto movieDto);

	MovieDto getMovie(long id);
}