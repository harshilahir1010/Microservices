package com.demo.ratingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	@Id
	private long ratingId;
	private long userId;
	private long hotelId;
	private int rating;
	private String feedback;

}
