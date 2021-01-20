package com.rachel.exercisetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachel.exercisetracker.entity.User;
import com.rachel.exercisetracker.repo.UserRepo;

@Service
public class UserService {
	
	@Autowired
	UserRepo userRepo;
	
	public List<User> getAllUser(){
		List<User> allUsers = new ArrayList<>();
		userRepo.findAll().forEach(user -> allUsers.add(user));
		return allUsers;
	}
	
	public void addUser(User u) {
		userRepo.save(u);
	}

}
