package com.rachel.exercisetracker.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Activity {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;

	@NotNull
    private String activityName;
	
	private String activityDate;

    private String activityDescription;

    private Double calories;
    
    @ManyToOne
    User user;

}
