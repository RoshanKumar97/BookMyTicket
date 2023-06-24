package com.bmt.bookmyticket.dto;

import jakarta.validation.constraints.Min;
import lombok.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowDto {

	private long id;

	@NotNull(message = "Show Date is Mandatory")
	private LocalDate showDate;

	@NotNull(message = "Show Time is Mandatory")
	private LocalTime showTime;

	@Min(value = 1, message = "Show Rate Multiplier Cannot be less than 1")
	private float rateMultiplier;

	@NotNull(message = "Movie is Mandatory for Show")
	private MovieDto movie;

	@NotNull(message = "Theater is Mandatory for Show")
	private TheaterDto theatre;

	private Date createdAt;

	private Date updatedAt;

	private MovieDto movieDto;

	private TheaterDto theaterDto;

	private List<ShowSeatsDto> seats;
}