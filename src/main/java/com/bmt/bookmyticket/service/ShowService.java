package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.PageResponse;
import com.bmt.bookmyticket.dto.ShowDto;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ShowService {

	ShowDto addShow(ShowDto showDto);

	PageResponse<ShowDto> searchShows(String movieName, String city, LocalDate showDate, LocalTime showTime, int pageNo, int limit);

}