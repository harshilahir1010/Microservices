package com.demo.hotelservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.hotelservice.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel,Long>{

}
