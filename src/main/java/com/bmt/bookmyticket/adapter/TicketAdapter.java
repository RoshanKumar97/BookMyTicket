package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.TicketDto;
import com.bmt.bookmyticket.model.TicketEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TicketAdapter {

	public static TicketEntity toEntity(TicketDto ticketDto) {

		return TicketEntity.builder()
				.allottedSeats(ticketDto.getAllottedSeats())
				.amount(ticketDto.getAmount())
				.build();

	}

	public static TicketDto toDto(TicketEntity ticketEntity) {

		return TicketDto.builder()
				.id(ticketEntity.getId())
				.allottedSeats(ticketEntity.getAllottedSeats())
				.amount(ticketEntity.getAmount())
				.show(ShowAdapter.toDto(ticketEntity.getShow()))
				.build();
	}

}