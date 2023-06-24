package com.bmt.bookmyticket.service;

import com.bmt.bookmyticket.dto.UserDto;

public interface UserService {

	UserDto addUser(UserDto userDto);

	UserDto getUser(long id);
}