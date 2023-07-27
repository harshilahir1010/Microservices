package com.demo.userservice.service;

import java.util.List;
import java.util.Optional;

import com.demo.userservice.entity.User;

public interface UserService {
	
	List<User> findAll();
	User findSpecific(long id);
	User saveUser(User user);
	User editUser(long id,User user);
	String deleteUser(long id);

}
