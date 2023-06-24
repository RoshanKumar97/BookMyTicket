package com.bmt.bookmyticket.service.impl;

import com.bmt.bookmyticket.adapter.ShowAdapter;
import com.bmt.bookmyticket.dto.PageResponse;
import com.bmt.bookmyticket.dto.ShowDto;
import com.bmt.bookmyticket.exception.DependencyException;
import com.bmt.bookmyticket.model.*;
import com.bmt.bookmyticket.repository.MovieRepository;
import com.bmt.bookmyticket.repository.ShowRepository;
import com.bmt.bookmyticket.repository.ShowSeatsRepository;
import com.bmt.bookmyticket.repository.TheaterRepository;
import com.bmt.bookmyticket.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService {

	@Autowired
	private ShowRepository showsRepository;

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private TheaterRepository theaterRepository;

	@Autowired
	private ShowSeatsRepository showSeatsRepository;

	@Override
	public ShowDto addShow(ShowDto showDto) {

		Optional<MovieEntity> optionalMovie = movieRepository.findById(showDto.getMovie().getId());

		if (!optionalMovie.isPresent()) {
			throw new DependencyException("Movie Not Found with ID: " + showDto.getMovie().getId() + " to add New Show");
		}

		Optional<TheaterEntity> optionalTheater = theaterRepository.findById(showDto.getTheatre().getId());

		if (!optionalTheater.isPresent()) {
			throw new DependencyException("Theater Not Found with ID: " + showDto.getMovie().getId() + " to add New Show");
		}

		ShowEntity showEntity = ShowAdapter.toEntity(showDto);

		showEntity.setMovie(optionalMovie.get());
		showEntity.setTheater(optionalTheater.get());
		showEntity.setSeats(generateShowSeats(showEntity.getTheater().getSeats(), showEntity));

		for (ShowSeatsEntity seatsEntity : showEntity.getSeats()) {
			seatsEntity.setShow(showEntity);
		}

		showEntity = showsRepository.save(showEntity);

		return ShowAdapter.toDto(showEntity);
	}

	private List<ShowSeatsEntity> generateShowSeats(List<TheaterSeatsEntity> theaterSeatsEntities, ShowEntity showEntity) {

		List<ShowSeatsEntity> showSeatsEntities = new ArrayList<>();

		for (TheaterSeatsEntity theaterSeatsEntity : theaterSeatsEntities) {

			ShowSeatsEntity showSeatsEntity =
					ShowSeatsEntity.builder()
							.seatNumber(theaterSeatsEntity.getSeatNumber())
							.seatType(theaterSeatsEntity.getSeatType())
							.rate((int) (theaterSeatsEntity.getRate() * showEntity.getRateMultiplier()))
							.build();

			showSeatsEntities.add(showSeatsEntity);
		}

		return showSeatsRepository.saveAll(showSeatsEntities);
	}

	@Override
	public PageResponse<ShowDto> searchShows(String movieName, String city, LocalDate showDate, LocalTime showTime, int pageNo, int limit) {

		Page<ShowEntity> showsPage = showsRepository.findAll(PageRequest.of(pageNo - 1, limit));

		PageResponse<ShowDto> pageResponse = new PageResponse<>();

		if (showsPage.hasContent()) {
			pageResponse.setNumber(pageNo);
			pageResponse.setRecords(showsPage.getNumberOfElements());

			pageResponse.setTotalPages(showsPage.getTotalPages());
			pageResponse.setTotalRecords(showsPage.getTotalElements());

			pageResponse.setData(ShowAdapter.toDto(showsPage.getContent()));
		}

		return pageResponse;
	}

}