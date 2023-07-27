package com.demo.ratingservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.ratingservice.entity.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long> {
	
	List<Rating> findByUserId(long uid);
	
	List<Rating> findByHotelId(long hid);

}
