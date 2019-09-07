package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.UserEntity;

public interface IUserRepository {
	Long insert(UserEntity userEntity);
}
