package com.bmt.bookmyticket.exception;

import lombok.Getter;

@Getter
public class DependencyException extends RuntimeException {

	private final String message;

	public DependencyException(String message) {
		super(message);
		this.message = message;
	}

}