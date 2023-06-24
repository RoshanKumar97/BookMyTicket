package com.bmt.bookmyticket.dto;

import com.bmt.bookmyticket.enums.SeatType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class BookTicketRequestDto {

	@NotEmpty(message = "Select atleast 1 Seat to Book")
	private Set<String> seatsNumbers;

	@Min(value = 1, message = "User is Invalid")
	private long userId;

	@Min(value = 1, message = "Show is Invalid")
	private long showId;

	@NotNull(message = "Seat Type is Mandatory to Book")
	private SeatType seatType;

}