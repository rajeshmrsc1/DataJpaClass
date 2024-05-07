package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.UserController;
import com.example.demo.dao.UserIRepo;
import com.example.demo.model.User;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class UserServiceImpl implements UserIService {

	@Autowired
	UserIRepo userIRepo;

	@Override
	public User getUserById(Integer id) {
		Optional<User> user =  userIRepo.findById(id);
		
//		log.info("req entered in service impl getUserById");
//		
//		log.debug(String.valueOf(user.isEmpty()));
//		log.debug(String.valueOf(user.isPresent()));
//		log.debug(user.get().toString());
//		log.debug(user.get().getId().toString());
//		
//		log.warn("don not call empty object");
		
		return user.isPresent() ? user.get() : new User();
	}

	@Override
	public List<User> getUsers() {
		log.info("request received into service impl");
		return userIRepo.findAll();
	}

	@Override
	public User saveUser(User user) {
		return userIRepo.save(user);
	}

	@Override
	public void deleteById(Integer id) {
		userIRepo.deleteById(id);
	}

	@Override
	public List<User> getUserByName(String name) {	
		return userIRepo.findUserByName(name);
	}

	@Override
	public List<User> getUserByAddress(String address) {
		return userIRepo.findUserByAddress(address);
	}

}
