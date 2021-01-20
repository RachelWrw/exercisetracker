package com.rachel.exercisetracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoActivityFoundException extends RuntimeException {
	public NoActivityFoundException(String msg) {
		super(msg);
	}
}
