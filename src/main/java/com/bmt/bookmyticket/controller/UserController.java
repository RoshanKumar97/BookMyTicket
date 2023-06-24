package com.bmt.bookmyticket.controller;

import com.bmt.bookmyticket.dto.UserDto;
import com.bmt.bookmyticket.service.UserService;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("add")
	public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {

		return ResponseEntity.ok(userService.addUser(userDto));
	}

	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUser(@PathVariable(name = "id") @Min(value = 1, message = "User Id Cannot be -ve") long id) {

		return ResponseEntity.ok(userService.getUser(id));
	}
}