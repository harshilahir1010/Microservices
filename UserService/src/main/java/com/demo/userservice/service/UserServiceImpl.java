package com.demo.userservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.userservice.entity.Hotel;
import com.demo.userservice.entity.Rating;
import com.demo.userservice.entity.User;
import com.demo.userservice.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User findSpecific(long id) {
		User user=repo.findById(id).get();
		Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getId(), Rating[].class);
		logger.info("{}",ratingOfUser);
		
		List<Rating> list = Arrays.stream(ratingOfUser).toList();
		
		List<Rating> ratings= list.stream().map(rating ->{
		  ResponseEntity<Hotel> entity=restTemplate.getForEntity("http://HOTEL-SERVICE/hotel/"+rating.getHotelId(), Hotel.class);
			Hotel hotel=entity.getBody();
			
			rating.setHotel(hotel);
			
			return rating;
		} ).collect(Collectors.toList());
		
	    user.setRating(ratings);
		return user;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return repo.save(user);
	}

	@Override
	public User editUser(long id, User user) {
		User u=repo.findById(id).get();
		u.setAbout(user.getAbout());
		u.setEmail(user.getEmail());
		u.setName(user.getName());
		
		
		return repo.save(u);
	}

	@Override
	public String deleteUser(long id) {
		User u=repo.findById(id).get();
		repo.delete(u);
		return "Deleted Sucessfully";
	}

}
