package com.rachel.exercisetracker.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Data
public class User {
	@Id
	String userName;
	String password;
	
	@JsonIgnoreProperties("user")
	@OneToMany(mappedBy = "user" )
	List<Activity> activities;

}
