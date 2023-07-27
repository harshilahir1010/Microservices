package com.demo.hotelservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hotelservice.entity.Hotel;
import com.demo.hotelservice.repo.HotelRepo;

@Service
public class HotelServiceImpl implements HotelService{
	
	@Autowired
	HotelRepo repo;

	@Override
	public List<Hotel> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Hotel findSpecific(long id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public Hotel save(Hotel hotel) {
		// TODO Auto-generated method stub
		return repo.save(hotel);
	}

	@Override
	public Hotel edit(long id, Hotel hotel) {
		Hotel h=repo.findById(id).get();
		h.setName(hotel.getName());
		h.setLocation(hotel.getLocation());
		return repo.save(h);
	}

	@Override
	public String delete(Long id) {
		Hotel hotel=repo.findById(id).get();
		repo.delete(hotel);
		return "Deleted";
	}

}
