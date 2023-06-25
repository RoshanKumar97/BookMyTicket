package com.bmt.bookmyticket.service.impl;

import com.bmt.bookmyticket.adapter.TheaterAdapter;
import com.bmt.bookmyticket.dto.TheaterDto;
import com.bmt.bookmyticket.enums.SeatType;
import com.bmt.bookmyticket.model.TheaterEntity;
import com.bmt.bookmyticket.model.TheaterSeatsEntity;
import com.bmt.bookmyticket.repository.TheaterRepository;
import com.bmt.bookmyticket.repository.TheaterSeatsRepository;
import com.bmt.bookmyticket.service.TheaterService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private TheaterSeatsRepository theaterSeatsRepository;

	@Override
	public TheaterDto addTheater(TheaterDto theaterDto) {

		TheaterEntity theaterEntity = TheaterAdapter.toEntity(theaterDto);

		theaterEntity.getSeats().addAll(getTheaterSeats());

		for (TheaterSeatsEntity seatsEntity : theaterEntity.getSeats()) {
			seatsEntity.setTheater(theaterEntity);
		}

		theaterEntity = theaterRepository.save(theaterEntity);

		return TheaterAdapter.toDto(theaterEntity);
	}

	private List<TheaterSeatsEntity> getTheaterSeats() {

		List<TheaterSeatsEntity> seats = new ArrayList<>();

		seats.add(getTheaterSeat("1A", SeatType.CLASSIC, 100));
		seats.add(getTheaterSeat("1B", SeatType.CLASSIC, 100));
		seats.add(getTheaterSeat("1C", SeatType.CLASSIC, 100));
		seats.add(getTheaterSeat("1D", SeatType.CLASSIC, 100));
		seats.add(getTheaterSeat("1E", SeatType.CLASSIC, 100));

		seats.add(getTheaterSeat("2A", SeatType.PREMIUM, 150));
		seats.add(getTheaterSeat("2B", SeatType.PREMIUM, 150));
		seats.add(getTheaterSeat("2C", SeatType.PREMIUM, 150));
		seats.add(getTheaterSeat("2D", SeatType.PREMIUM, 150));
		seats.add(getTheaterSeat("2E", SeatType.PREMIUM, 150));

		seats = theaterSeatsRepository.saveAll(seats);

		return seats;
	}

	private TheaterSeatsEntity getTheaterSeat(String seatNumber, SeatType seatType, int rate) {
		return TheaterSeatsEntity.builder().seatNumber(seatNumber).seatType(seatType).rate(rate).build();
	}

	@Override
	public TheaterDto getTheater(long id) {

		Optional<TheaterEntity> theaterEntity = theaterRepository.findById(id);

		if (!theaterEntity.isPresent()) {
			throw new EntityNotFoundException("Theater Not Found with ID: " + id);
		}

		return TheaterAdapter.toDto(theaterEntity.get());
	}

	@Override
	public List<TheaterDto> getAllTheater() {
		List<TheaterEntity> theaterEntities = theaterRepository.findAll();
		return TheaterAdapter.toDto(theaterEntities);
	}

}