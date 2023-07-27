package com.demo.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.demo.userservice.entity.User;
import com.demo.userservice.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findSpecific(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveUser(user));
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editUser(@RequestBody User user,@PathVariable long id){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.editUser(id,user));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
	}
	

}
