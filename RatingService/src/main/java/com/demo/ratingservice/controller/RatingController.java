package com.demo.ratingservice.controller;

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

import com.demo.ratingservice.entity.Rating;
import com.demo.ratingservice.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService service;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<?> findByUserId(@PathVariable long userId){
		return ResponseEntity.status(HttpStatus.OK).body(service.getByUserId(userId));
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<?> findByHotelId(@PathVariable long hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.getByHotelId(hotelId));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> findAll(){
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
	}
	
	@GetMapping("/{hotelId}")
	public ResponseEntity<?> findById(@PathVariable long hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.findSpecific(hotelId));
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(rating));
	}
	
	@PutMapping("/edit/{hotelId}")
	public ResponseEntity<?> editRating(@PathVariable long hotelId,@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.edit(rating, hotelId));
	}
	
	@DeleteMapping("/delete/{hotelId}")
	public ResponseEntity<?> deleteRating(@PathVariable long hotelId){
		return ResponseEntity.status(HttpStatus.OK).body(service.delete(hotelId));
	}

}
