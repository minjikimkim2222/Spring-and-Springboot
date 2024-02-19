package com.firstWebApplication.springboot.myfirstWebapp.todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

// Database (MySQL)
// Static List of todos -> Database(H2, MySQL)

// JPA
// Bean -> Database

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private int id;

	private String username;

	@Size(min = 10, message = "Enter at least 10 characters")
	private String description;

	private LocalDate deadline;
	private boolean Done;

	public Todo() {

	}

	public Todo(int id, String username, String description, LocalDate deadline, boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.deadline = deadline;
		Done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDate deadline) {
		this.deadline = deadline;
	}

	public boolean isDone() {
		return Done;
	}

	public void setDone(boolean done) {
		Done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", deadline=" + deadline
				+ ", Done=" + Done + "]";
	}

}
