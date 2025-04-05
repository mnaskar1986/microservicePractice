package com.springboot.practice.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {
	
	@GetMapping("/v1/person")
	public Personv1 getFirstPerson() {
		return new Personv1("Madhumita Naskar");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getSecondPerson() {
		return new Personv2(new Name("Madhumita", "Naskar"));
	}
	
	@GetMapping(path="person", params= "version=1")
	public Personv1 getFirstPersonRequestParam() {
		return new Personv1("Madhumita Naskar");
	}

	@GetMapping(path= "person", params = "version=2")
	public Personv2 getSecondPersonRequestParam() {
		return new Personv2(new Name("Madhumita", "Naskar"));
	}
}
