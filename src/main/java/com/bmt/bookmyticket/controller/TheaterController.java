package com.bmt.bookmyticket.controller;

import com.bmt.bookmyticket.dto.TheaterDto;
import com.bmt.bookmyticket.service.TheaterService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cinema")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@PostMapping("add")
	public ResponseEntity<TheaterDto> addUser(@RequestBody TheaterDto theaterDto) {

		return ResponseEntity.ok(theaterService.addTheater(theaterDto));
	}

	@GetMapping("{id}")
	public ResponseEntity<TheaterDto> getUser(@PathVariable(name = "id") @Min(value = 1, message = "Theater Id Cannot be -ve") long id) {

		return ResponseEntity.ok(theaterService.getTheater(id));
	}

	@GetMapping("all")
	public ResponseEntity<List<TheaterDto>> getAllCinemas(){
		return ResponseEntity.ok(theaterService.getAllTheater());
	}
}