package com.sanjay.blog.services;

import java.util.List;

import com.sanjay.blog.payload.UserDto;

public interface UserService {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user,Integer id);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUser();
	void deleteUser(Integer userId);
}
