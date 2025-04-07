package com.springboot.practice.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {

	@GetMapping("/employeeFiltering")
	public EmployeeFiltering getEmployee() {
		return new EmployeeFiltering("Ram", "ram123", "Finance");
	}
	
	@GetMapping("/list-employeeFiltering")
	public List<EmployeeFiltering> getEmployeeList() {
		return Arrays.asList(new EmployeeFiltering("Ram", "ram123", "Finance"),
				new EmployeeFiltering("Raj", "raj123", "Health"));
	}
}
