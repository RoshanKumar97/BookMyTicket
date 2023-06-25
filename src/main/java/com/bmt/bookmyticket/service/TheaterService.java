package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.TheaterDto;

public interface TheaterService {

	TheaterDto addTheater(TheaterDto theaterDto);

	TheaterDto getTheater(long id);
}