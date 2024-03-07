package com.minjiki2.rest.webservices.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {

	private UserDaoService service;

	@Autowired
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}

	// GET /users
	@GetMapping("/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// http://localhost:8080/users
	// EntityModel
	// WebMvcLinkBuilder

	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable("id") int id) {
		User user = service.findOne(id);

		if (user == null) {
			throw new UserNotFoundException("id" + id);
		}

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-Users"));

		return entityModel;
	}

	// POST /users
	@PostMapping("/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {

		User savedUser = service.save(user);
		// /users/4 => /users/{id}, user.getID
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()

				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	// DELETE /users/{id}
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		service.deleteById(id);
	}
}
