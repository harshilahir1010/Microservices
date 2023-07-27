package com.demo.ratingservice.service;

import java.util.List;

import com.demo.ratingservice.entity.Rating;

public interface RatingService {
	
	List<Rating> findAll();
	Rating findSpecific(long id);
	Rating save(Rating rating);
	Rating edit(Rating rating,long id);
	String delete(long id);
	List<Rating> getByHotelId(long id);
	List<Rating> getByUserId(long id);

}
