package com.bmt.bookmyticket.service.impl;

import com.bmt.bookmyticket.adapter.UserAdapter;
import com.bmt.bookmyticket.dto.UserDto;
import com.bmt.bookmyticket.exception.DuplicateRecordException;
import com.bmt.bookmyticket.model.UserEntity;
import com.bmt.bookmyticket.repository.UserRepository;
import com.bmt.bookmyticket.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto addUser(UserDto userDto) {

		if (userRepository.existsByMobile(userDto.getMobile())) {
			throw new DuplicateRecordException("User Already Exists with Mobile: " + userDto.getMobile());
		}

		UserEntity userEntity = UserAdapter.toEntity(userDto);

		userEntity = userRepository.save(userEntity);

		return UserAdapter.toDto(userEntity);
	}

	@Override
	public UserDto getUser(long id) {

		Optional<UserEntity> userEntity = userRepository.findById(id);

		if (!userEntity.isPresent()) {
			throw new EntityNotFoundException("User Not Found with ID: " + id);
		}

		return UserAdapter.toDto(userEntity.get());
	}

}