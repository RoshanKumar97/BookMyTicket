package com.bmt.bookmyticket.dto;

import com.bmt.bookmyticket.enums.SeatType;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class ShowSeatsDto {

	private long id;

	private String seatNumber;

	private int rate;

	private SeatType seatType;

	private boolean booked;

	private Date bookedAt;

}