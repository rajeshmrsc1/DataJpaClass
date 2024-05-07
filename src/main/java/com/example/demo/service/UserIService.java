package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserIService {

	User getUserById(Integer id);
	List<User> getUsers();
	User saveUser(User user);
	void deleteById(Integer id);
	List<User> getUserByName(String name);
	List<User> getUserByAddress(String address);
}
