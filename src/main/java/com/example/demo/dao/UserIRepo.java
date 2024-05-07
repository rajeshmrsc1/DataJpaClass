package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserIRepo extends JpaRepository<User, Integer> {
	List<User> findUserByName(String name);
	List<User> findUserByAddress(String address);
}
