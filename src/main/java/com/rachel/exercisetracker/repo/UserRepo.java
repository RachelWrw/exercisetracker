package com.rachel.exercisetracker.repo;

import org.springframework.data.repository.CrudRepository;

import com.rachel.exercisetracker.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

}
