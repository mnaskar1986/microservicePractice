package com.springboot.practice.user;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.practice.user.exception.UserNotFoundException;

@RestController
public class UserController {
	
	private UserDaoService service;
	
	public UserController(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<UserDao> retrieveUsers() {
		return service.retrieveAllUser();
	}
	
	@GetMapping("/users/{id}")
	public UserDao getUserById(@PathVariable int id) {
		UserDao user = service.getUserById(id);
		if(user == null) {
			throw new UserNotFoundException("User id: " + id + " is not present!");
		}
		return user;
	}

	@PostMapping("/users")
	public void saveUser(@RequestBody UserDao user) {
		service.saveUser(user);
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUserByID(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
}
