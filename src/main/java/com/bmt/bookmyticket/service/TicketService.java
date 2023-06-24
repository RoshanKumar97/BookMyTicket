package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.BookTicketRequestDto;
import com.bmt.bookmyticket.dto.TicketDto;

public interface TicketService {

	TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto);

	TicketDto getTicket(long id);
}