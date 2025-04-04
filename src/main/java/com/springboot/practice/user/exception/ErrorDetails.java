package com.springboot.practice.user.exception;

import java.time.LocalDateTime;

public class ErrorDetails{
	
	private String message;
	private String description;
	private LocalDateTime time;
	
	public ErrorDetails(String message, String description, LocalDateTime time) {
		super();
		this.message = message;
		this.description = description;
		this.time = time;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

	public LocalDateTime getTime() {
		return time;
	}
}
