package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.TheaterDto;

import java.util.List;

public interface TheaterService {

	TheaterDto addTheater(TheaterDto theaterDto);

	TheaterDto getTheater(long id);

	List<TheaterDto> getAllTheater();
}