package com.demo.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
	
	private long ratingId;
	private long userId;
	private long hotelId;
	private int ratings;
	private String feedback;

}
