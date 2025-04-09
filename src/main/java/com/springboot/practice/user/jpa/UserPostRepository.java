package com.springboot.practice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.practice.user.UserPost;

public interface UserPostRepository extends JpaRepository<UserPost, Integer>{

}
