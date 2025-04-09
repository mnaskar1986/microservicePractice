package com.springboot.practice.user;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

@Entity
public class UserDao {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min=2, message="At least 2 characters needs to be there in the name!")
	private String name;
	
	@Past(message="Date of birth should be in past!")
	private LocalDate dateOfBirth;
	
	@OneToMany(mappedBy = "userDao")
	@JsonIgnore
	private List<UserPost> posts;
	
	protected UserDao() {
		
	}
	
	public UserDao(Integer id, String name, LocalDate dateOfBirth) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<UserPost> getPosts() {
		return posts;
	}

	public void setPosts(List<UserPost> posts) {
		this.posts = posts;
	}

	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
