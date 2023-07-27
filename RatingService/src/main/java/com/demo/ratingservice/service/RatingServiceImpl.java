package com.demo.ratingservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.ratingservice.entity.Rating;
import com.demo.ratingservice.repo.RatingRepo;

@Service
public class RatingServiceImpl implements RatingService{

	@Autowired
	RatingRepo repo;
	
	@Override
	public List<Rating> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Rating findSpecific(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Rating save(Rating rating) {
		// TODO Auto-generated method stub
		return repo.save(rating);
	}

	@Override
	public Rating edit(Rating rating, long id) {
		Rating r=repo.findById(id).get();
		r.setUserId(rating.getUserId());
		r.setRating(rating.getRating());
		r.setHotelId(rating.getHotelId());
		r.setFeedback(rating.getFeedback());
		return repo.save(r);
	}

	@Override
	public String delete(long id) {
		// TODO Auto-generated method stub
		Rating rating=repo.findById(id).get();
		repo.delete(rating);
		return "Deleted";
	}

	@Override
	public List<Rating> getByHotelId(long id) {
		// TODO Auto-generated method stub
		return repo.findByHotelId(id);
	}

	@Override
	public List<Rating> getByUserId(long id) {
		// TODO Auto-generated method stub
		return repo.findByUserId(id);
	}

}
