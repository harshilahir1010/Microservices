package com.demo.hotelservice.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(NoSuchElementException.class)
	public Map<String, String> handleException(NoSuchElementException exception){
		Map<String, String> map=new HashMap<>();
		map.put("error message",exception.getMessage());
		return map;
	}

}
