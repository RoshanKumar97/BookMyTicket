package com.bmt.bookmyticket.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class TheaterDto {

	private long id;

	private String name;

	private String city;

	private String address;

	private List<ShowDto> shows;
}