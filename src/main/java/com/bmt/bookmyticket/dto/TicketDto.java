package com.bmt.bookmyticket.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TicketDto {

	private long id;

	private String allottedSeats;

	private double amount;

	private Date bookedAt;

	private ShowDto show;
}