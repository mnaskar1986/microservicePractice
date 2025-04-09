package com.springboot.practice.user.jpa;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.practice.user.UserDao;
import com.springboot.practice.user.UserPost;
import com.springboot.practice.user.exception.UserNotFoundException;

import jakarta.validation.Valid;

@RestController
public class UserJpaController {
	
	private UserRepository repository;
	
	private UserPostRepository postRepository;
	
	public UserJpaController(UserRepository repository, UserPostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<UserDao> retrieveUsers() {
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<UserDao> getUserById(@PathVariable int id) {
		Optional<UserDao> user = repository.findById(id);
		if(user == null || user.isEmpty()) {
			throw new UserNotFoundException("User id: " + id + " is not present!");
		}
		EntityModel<UserDao> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveUsers()); 
		entityModel.add(link.withRel("all-user"));
		return entityModel;
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<UserDao> saveUser(@Valid @RequestBody UserDao user) {
		UserDao savedUser= repository.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUserByID(@PathVariable int id) {
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/post")
	public List<UserPost> retrievePostForUser(@PathVariable int id) {
		Optional<UserDao> user = repository.findById(id);
		if(user == null || user.isEmpty()) {
			throw new UserNotFoundException("User id: " + id + " is not present!");
		}
		return user.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/post")
	public ResponseEntity<UserPost> createPostForUser(@PathVariable int id, @Valid @RequestBody UserPost post) {
		
		Optional<UserDao> user = repository.findById(id);
		if(user == null || user.isEmpty()) {
			throw new UserNotFoundException("User id: " + id + " is not present!");
		}
		post.setUserDao(user.get());
		UserPost savedPost = postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(savedPost.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
}
