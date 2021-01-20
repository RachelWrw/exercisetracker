package com.rachel.exercisetracker.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.rachel.exercisetracker.entity.Activity;

public interface TrackerRepo extends CrudRepository<Activity, Integer>   {
	
	List<Activity> findByActivityNameAndActivityDate(String activityName, String date);
	List<Activity> findByActivityName(String activityName);
	List<Activity> findByActivityDate(String date);
	
	/*
	@Override
    @Query("select a from Activity a join fetch a.user u")
    List<Activity> findAll();*/
}
