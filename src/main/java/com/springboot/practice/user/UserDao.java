package com.springboot.practice.user;

import java.time.LocalDate;

public class UserDao {
	
	private Integer id;
	private String name;
	private LocalDate dateOfBirth;
	
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

	@Override
	public String toString() {
		return "UserDao [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + "]";
	}

}
