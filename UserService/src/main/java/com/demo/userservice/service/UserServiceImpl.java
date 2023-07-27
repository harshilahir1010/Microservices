package com.demo.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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
		ArrayList<Rating> forObject = restTemplate.getForObject("http://localhost:8082/rating/user/"+user.getId(), ArrayList.class);
		
		logger.info("{}",forObject);
		System.out.println(forObject);
	    user.setRating(forObject);
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
