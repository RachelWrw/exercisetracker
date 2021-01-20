package com.rachel.exercisetracker.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rachel.exercisetracker.entity.Activity;
import com.rachel.exercisetracker.exception.NoActivityFoundException;
import com.rachel.exercisetracker.repo.TrackerRepo;

@Service
public class TrackerService {
	
	@Autowired
	TrackerRepo trackerRepo;

	public List<Activity> getAllActivity(){
		List<Activity> allActivities = new ArrayList<>();  
		trackerRepo.findAll().forEach(activity -> allActivities.add(activity));
		return allActivities;
	}
	
	public void addActivity(Activity activity)   
	{  
		trackerRepo.save(activity);  
	}  
	
	public Activity getActivity(Integer id) throws Exception{
		return trackerRepo.findById(id).orElseThrow(() -> new NoActivityFoundException("Activity ID: " + id));
	}
	
	public List<Activity> getActivity(String activityName, String date){
		List<Activity> result = new ArrayList<>();
		if(activityName == null || activityName.isEmpty()) {
			trackerRepo.findByActivityDate(date).forEach(activity -> result.add(activity));
			if (result.isEmpty()) throw new NoActivityFoundException( "Date:  " + date);
			return result;
		}
		if(date == null || date.isEmpty()) {
			trackerRepo.findByActivityName(activityName).forEach(activity -> result.add(activity));
			if (result.isEmpty()) throw new NoActivityFoundException("ActivityName " + activityName);
			return result;
		}
		
		trackerRepo.findByActivityNameAndActivityDate(activityName, date).forEach(activity -> result.add(activity));
		if (result.isEmpty()) throw new NoActivityFoundException(activityName + " on " + date);
		return result;
	}
	
	 public void deleteActivity(Integer id) {
		 trackerRepo.deleteById(id);
		 
	 }
	
}
