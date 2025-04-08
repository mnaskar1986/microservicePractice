package com.springboot.practice.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

//@JsonIgnoreProperties("name")
@JsonFilter("employeeFilter")
public class EmployeeFiltering {
	
	private String name;
	private String password;
	private String Department;
	
	public EmployeeFiltering(String name, String password, String department) {
		super();
		this.name = name;
		this.password = password;
		Department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	@Override
	public String toString() {
		return "EmployeeFiltering [name=" + name + ", password=" + password + ", Department=" + Department + "]";
	}

}
