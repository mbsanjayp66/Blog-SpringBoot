package com.sanjay.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanjay.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
