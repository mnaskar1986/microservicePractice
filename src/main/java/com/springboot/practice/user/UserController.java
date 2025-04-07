package com.springboot.practice.user;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.practice.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService service;
	private MessageSource messageSource;
	
	public UserController(UserDaoService service, MessageSource messageSource) {
		this.service = service;
		this.messageSource = messageSource;
	}
	
	@GetMapping("/users")
	public List<UserDao> retrieveUsers() {
		return service.retrieveAllUser();
	}
	
	@GetMapping("/users/{id}")
	public EntityModel<UserDao> getUserById(@PathVariable int id) {
		UserDao user = service.getUserById(id);
		if(user == null) {
			throw new UserNotFoundException("User id: " + id + " is not present!");
		}
		EntityModel<UserDao> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveUsers()); 
		entityModel.add(link.withRel("all-user"));
		return entityModel;
	}

	@PostMapping("/users")
	public ResponseEntity<UserDao> saveUser(@Valid @RequestBody UserDao user) {
		UserDao savedUser= service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@GetMapping("/hello-world-internalization")
	public String getGreetingMessage() {
		Locale locale = LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.morning.message", null, "default message", locale);
	}
	
	@DeleteMapping("users/{id}")
	public void deleteUserByID(@PathVariable int id) {
		service.deleteUserById(id);
	}
	
}
