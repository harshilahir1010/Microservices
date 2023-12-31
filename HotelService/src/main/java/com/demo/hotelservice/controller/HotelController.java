package com.demo.hotelservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.hotelservice.entity.Hotel;
import com.demo.hotelservice.service.HotelService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired
	HotelService service;
	
	@GetMapping("/")
	public ResponseEntity<?> getAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getSpecific(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(id));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody @Valid Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(hotel));
	}
	
	@PutMapping("/edit/{id}")
	public ResponseEntity<?> editUser(@PathVariable long id,@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(id, hotel));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(id));
	}

}
