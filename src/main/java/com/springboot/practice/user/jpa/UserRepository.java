package com.springboot.practice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.practice.user.UserDao;

public interface UserRepository extends JpaRepository<UserDao, Integer>{

}
