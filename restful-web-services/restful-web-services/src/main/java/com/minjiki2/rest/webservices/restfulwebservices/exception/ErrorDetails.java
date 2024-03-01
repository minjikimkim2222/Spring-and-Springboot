package com.minjiki2.rest.webservices.restfulwebservices.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	// timestamp : 에러 발생 시간
	// message : 에러 메시지
	// details : 에러 상세 정보

	private LocalDateTime timestamp;
	private String message;
	private String details;

	// Constructor
	public ErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	// getters
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
