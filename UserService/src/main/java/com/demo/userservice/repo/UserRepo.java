package com.demo.userservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.userservice.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
