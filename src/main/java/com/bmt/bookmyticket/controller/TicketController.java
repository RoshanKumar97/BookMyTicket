package com.bmt.bookmyticket.controller;

import com.bmt.bookmyticket.dto.BookTicketRequestDto;
import com.bmt.bookmyticket.dto.TicketDto;
import com.bmt.bookmyticket.service.TicketService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("ticket")
public class TicketController {

	@Autowired
	private TicketService ticketService;

	@PostMapping("book")
	public ResponseEntity<TicketDto> bookTicket(@RequestBody BookTicketRequestDto bookTicketRequestDto) {

		return ResponseEntity.ok(ticketService.bookTicket(bookTicketRequestDto));
	}

	@GetMapping("{id}")
	public ResponseEntity<TicketDto> getTicket(@PathVariable(name = "id") @Min(value = 1, message = "Ticket Id Cannot be -ve") long id) {

		return ResponseEntity.ok(ticketService.getTicket(id));
	}
}