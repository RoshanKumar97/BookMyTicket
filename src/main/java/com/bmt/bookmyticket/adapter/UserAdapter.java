package com.bmt.bookmyticket.adapter;

import com.bmt.bookmyticket.dto.UserDto;
import com.bmt.bookmyticket.model.UserEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserAdapter {

	public static UserEntity toEntity(UserDto userDto) {

		return UserEntity.builder()
				.name(userDto.getName())
				.mobile(userDto.getMobile())
				.build();

	}

	public static UserDto toDto(UserEntity userEntity) {

		return UserDto.builder()
				.id(userEntity.getId())
				.name(userEntity.getName())
				.mobile(userEntity.getMobile())
				.build();
	}

}