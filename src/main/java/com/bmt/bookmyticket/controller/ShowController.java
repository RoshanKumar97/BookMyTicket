package com.bmt.bookmyticket.controller;

import com.bmt.bookmyticket.dto.PageResponse;
import com.bmt.bookmyticket.dto.ShowDto;
import com.bmt.bookmyticket.service.ShowService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("show")
public class ShowController {

	@Autowired
	private ShowService showService;

	@GetMapping("/search/{pageNo}/{limit}")
	public ResponseEntity<PageResponse<ShowDto>> search(
			@PathVariable(name = "pageNo") @Min(value = 1, message = "Page No Cannot be less than 1") int pageNo,
			@PathVariable(name = "limit") @Min(value = 1, message = "Limit Cannot be less than 1") int limit,
			@RequestParam(name = "movieName", required = false) String movieName,
			@RequestParam(name = "city", required = false) String city,
			@RequestParam(name = "showDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate showDate,
			@RequestParam(name = "showTime", required = false) @DateTimeFormat(pattern = "HH:mm:ss") LocalTime showTime) {

		return ResponseEntity.ok(showService.searchShows(movieName, city, showDate, showTime, pageNo, limit));
	}

	@GetMapping("details/{id}")
	public ResponseEntity<List<ShowDto>> showDetails(
			@PathVariable(name = "id") long movieId){
		return ResponseEntity.ok(showService.showDetailsById(movieId));
	}

	@PostMapping("add")
	public ResponseEntity<ShowDto> addShow(@RequestBody ShowDto showDto) {

		return ResponseEntity.ok(showDto);
	}

}