package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.IUserService;

public class UserService implements IUserService {

	@Override
	public UserDTO save(UserDTO newUser) {
		UserConverter converter= new UserConverter();
		UserEntity userEntity = converter.convertToEntity(newUser);
		return null;
	}
	
}
