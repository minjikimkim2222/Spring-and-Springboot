package com.minjiki2.rest.webservices.restfulwebservices.helloworld;

public class HelloWorldBean {

	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	// getters and setters
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// toString
	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
