package com.bmt.bookmyticket.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class UserDto {

	private long id;

	@NotBlank(message = "User name is Mandatory")
	private String name;

	@NotBlank(message = "Mobile is Mandatory")
	private String mobile;

	private List<TicketDto> tickets;
}