package com.demo.hotelservice.service;

import java.util.List;

import com.demo.hotelservice.entity.Hotel;

public interface HotelService {
	
	List<Hotel> findAll();
	Hotel findSpecific(long id);
	Hotel save(Hotel hotel);
	Hotel edit(long id,Hotel hotel);
	String delete(Long id);

}
