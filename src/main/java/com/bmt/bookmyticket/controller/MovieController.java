package com.bmt.bookmyticket.controller;

import com.bmt.bookmyticket.dto.MovieDto;
import com.bmt.bookmyticket.service.MovieService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

	@Autowired
	private MovieService movieService;

	@PostMapping("add")
	public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {

		return ResponseEntity.ok(movieService.addMovie(movieDto));
	}

	@GetMapping("{id}")
	public ResponseEntity<MovieDto> getUser(@PathVariable(name = "id") @Min(value = 1, message = "Movie Id Cannot be -ve") long id) {

		return ResponseEntity.ok(movieService.getMovie(id));
	}
}