package com.bmt.bookmyticket.service.impl;

import com.bmt.bookmyticket.adapter.TicketAdapter;
import com.bmt.bookmyticket.dto.BookTicketRequestDto;
import com.bmt.bookmyticket.dto.TicketDto;
import com.bmt.bookmyticket.exception.DependencyException;
import com.bmt.bookmyticket.model.ShowEntity;
import com.bmt.bookmyticket.model.ShowSeatsEntity;
import com.bmt.bookmyticket.model.TicketEntity;
import com.bmt.bookmyticket.model.UserEntity;
import com.bmt.bookmyticket.repository.ShowRepository;
import com.bmt.bookmyticket.repository.TicketRepository;
import com.bmt.bookmyticket.repository.UserRepository;
import com.bmt.bookmyticket.service.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public TicketDto bookTicket(BookTicketRequestDto bookTicketRequestDto) {

		Optional<UserEntity> optionalUser = userRepository.findById(bookTicketRequestDto.getUserId());

		if (!optionalUser.isPresent()) {
			throw new DependencyException("User Not Found with ID: " + bookTicketRequestDto.getUserId() + " to book ticket");
		}

		Optional<ShowEntity> optionalShow = showRepository.findById(bookTicketRequestDto.getShowId());

		if (!optionalShow.isPresent()) {
			throw new DependencyException("Show Not Found with ID: " + bookTicketRequestDto.getUserId() + " to book ticket");
		}

		Set<String> requestedSeats = bookTicketRequestDto.getSeatsNumbers();

		List<ShowSeatsEntity> showSeatsEntities = optionalShow.get().getSeats();

		showSeatsEntities =
				showSeatsEntities
						.stream()
						.filter(seat -> seat.getSeatType().equals(bookTicketRequestDto.getSeatType())
								&& !seat.isBooked()
								&& requestedSeats.contains(seat.getSeatNumber()))
						.collect(Collectors.toList());

		if (showSeatsEntities.size() != requestedSeats.size()) {
			throw new DependencyException("Seats Not Available for Booking");
		}

		TicketEntity ticketEntity =
				TicketEntity.builder()
						.user(optionalUser.get())
						.show(optionalShow.get())
						.seats(showSeatsEntities)
						.build();

		double amount = 0.0;
		String allottedSeats = "";

		for (ShowSeatsEntity seatsEntity : showSeatsEntities) {
			seatsEntity.setBooked(true);
			seatsEntity.setBookedAt(new Date());
			seatsEntity.setTicket(ticketEntity);

			amount += seatsEntity.getRate();

			allottedSeats += seatsEntity.getSeatNumber() + " ";
		}

		ticketEntity.setAmount(amount);
		ticketEntity.setAllottedSeats(allottedSeats);

		if (CollectionUtils.isEmpty(optionalUser.get().getTicketEntities())) {
			optionalUser.get().setTicketEntities(new ArrayList<>());
		}

		optionalUser.get().getTicketEntities().add(ticketEntity);

		if (CollectionUtils.isEmpty(optionalShow.get().getTickets())) {
			optionalShow.get().setTickets(new ArrayList<>());
		}

		optionalShow.get().getTickets().add(ticketEntity);

		ticketEntity = ticketRepository.save(ticketEntity);

		return TicketAdapter.toDto(ticketEntity);
	}

	@Override
	public TicketDto getTicket(long id) {

		Optional<TicketEntity> ticketEntity = ticketRepository.findById(id);

		if (!ticketEntity.isPresent()) {
			throw new EntityNotFoundException("Ticket Not Found with ID: " + id);
		}

		return TicketAdapter.toDto(ticketEntity.get());
	}

}