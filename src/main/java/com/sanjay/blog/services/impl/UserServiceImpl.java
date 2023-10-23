package com.sanjay.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sanjay.blog.entities.User;
import com.sanjay.blog.exceptions.ResourceNotFoundException;
import com.sanjay.blog.payload.UserDto;
import com.sanjay.blog.repositories.UserRepo;
import com.sanjay.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {
		
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto user) {
		return userToDto(userRepo.save(dtoToUser(user)));
	}

	@Override
	public UserDto updateUser(UserDto userdto,Integer id) {
		User user  = this.userRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("User","id",id));
		user.setName(userdto.getName());
		user.setEmail(userdto.getEmail());
		user.setPassword(userdto.getPassword());
		user.setAbout(userdto.getAbout());
		return userToDto(this.userRepo.save(user));
	}

	@Override
	public UserDto getUserById(Integer userId) {
		return userToDto(userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId)));
	}

	@Override
	public List<UserDto> getAllUser() {
		return this.userRepo.findAll().stream().map(user->userToDto(user)).collect(Collectors.toList());
	}

	@Override
	public void deleteUser(Integer userId) {
		User user  = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		this.userRepo.delete(user);

	}
	
	private User dtoToUser(UserDto userDto) {
		return this.modelMapper.map(userDto,User.class);
		//return new User(userDto.getId(),userDto.getName(),userDto.getEmail(),userDto.getPassword(),userDto.getAbout());
	}
	
	private UserDto userToDto(User user) {
		return this.modelMapper.map(user, UserDto.class);
		//return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getAbout());
	}

}
