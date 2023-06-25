package com.bmt.bookmyticket.service.impl;

import com.bmt.bookmyticket.adapter.MovieAdapter;
import com.bmt.bookmyticket.dto.MovieDto;
import com.bmt.bookmyticket.exception.DuplicateRecordException;
import com.bmt.bookmyticket.model.MovieEntity;
import com.bmt.bookmyticket.repository.MovieRepository;
import com.bmt.bookmyticket.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public MovieDto addMovie(MovieDto movieDto) {

		if (movieRepository.existsByName(movieDto.getName())) {
			throw new DuplicateRecordException("Movie Already Exists with Name: " + movieDto.getName());
		}

		MovieEntity movieEntity = MovieAdapter.toEntity(movieDto);
		System.out.println(movieEntity);

		movieEntity = movieRepository.save(movieEntity);

		return MovieAdapter.toDto(movieEntity);
	}

	@Override
	public MovieDto getMovie(long id) {

		Optional<MovieEntity> movieEntity = movieRepository.findById(id);

		if (!movieEntity.isPresent()) {
			throw new EntityNotFoundException("Movie Not Found with ID: " + id);
		}

		return MovieAdapter.toDto(movieEntity.get());
	}

	@Override
	public List<MovieDto> getAllMovies() {
		return MovieAdapter.toDto(movieRepository.findAll());
	}

}