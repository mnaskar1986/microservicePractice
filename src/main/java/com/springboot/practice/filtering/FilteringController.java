package com.springboot.practice.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/employeeFiltering")
	public MappingJacksonValue getEmployee() {
		EmployeeFiltering emp = new EmployeeFiltering("Ram", "ram123", "Finance");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(emp );
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name", "department");
		FilterProvider filters = new SimpleFilterProvider().addFilter("employeeFilter", filter);
		mappingJacksonValue.setFilters(filters);
		return mappingJacksonValue; 
	}
	
	@GetMapping("/list-employeeFiltering")
	public MappingJacksonValue getEmployeeList() {
		List<EmployeeFiltering> empList = new ArrayList<EmployeeFiltering> ();
		empList.add(new EmployeeFiltering("Ram", "ram123", "Finance"));
		empList.add(new EmployeeFiltering("Raj", "raj123", "Health"));
		
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(empList);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("password", "department");
		FilterProvider filters = new SimpleFilterProvider().addFilter("employeeFilter", filter);
		mappingJacksonValue.setFilters(filters);		
		return mappingJacksonValue;
	}
}
