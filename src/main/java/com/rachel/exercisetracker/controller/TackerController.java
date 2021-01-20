package com.rachel.exercisetracker.controller;

import org.springframework.web.bind.annotation.RestController;

import com.rachel.exercisetracker.entity.Activity;
import com.rachel.exercisetracker.entity.User;
import com.rachel.exercisetracker.service.TrackerService;
import com.rachel.exercisetracker.service.UserService;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class TackerController {
	
	@Autowired
	TrackerService trackerService;
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	
	@RequestMapping("/allActivities")
	List<Activity> getAllActivities() {
		return trackerService.getAllActivity();
	}
	
	@RequestMapping("/findActivity")
	Activity findActivityById(@RequestParam Integer id) throws Exception {
		return trackerService.getActivity(id);
		
	}
	
	@RequestMapping("/findActivities") 
	List<Activity> findActivityByNameAndDate(@RequestParam(required=false) String name, @RequestParam(required=false) String date) throws Exception {
		return trackerService.getActivity(name, date);
		
	}
	
	@PostMapping("/addActivity")  
	Integer addActivity(@RequestBody Activity activity){  
		trackerService.addActivity(activity);;  
		return activity.getActivityId();  
	}  
	
	@DeleteMapping("/deleteActivity")
	void deleteActivity(Integer id) {
		trackerService.deleteActivity(id);
	}
	
	@RequestMapping("/allUsers")
	List<User> getAllUsers(){
		return userService.getAllUser();
		
	}
	
	@PostMapping("/addUser")  
	String addActivity(@RequestBody User u){  
		userService.addUser(u);;  
		return u.getUserName();  
	}  
	
	
}
