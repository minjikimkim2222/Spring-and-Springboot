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

import com.minjiki2.rest.webservices.restfulwebservices.jpa.PostRepository;
import com.minjiki2.rest.webservices.restfulwebservices.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository repository;
	private PostRepository postRepository;

	@Autowired
	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		super();
		this.repository = repository;
		this.postRepository = postRepository;
	}

	// GET /users
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return repository.findAll();
	}

	// http://localhost:8080/users
	// EntityModel
	// WebMvcLinkBuilder

	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retrieveOneUser(@PathVariable("id") int id) {
		User user = repository.findById(id).get();

		if (user == null) {
			throw new UserNotFoundException("id" + id);
		}

		EntityModel<User> entityModel = EntityModel.of(user);

		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-Users"));

		return entityModel;
	}

	// POST /users
	@PostMapping("/jpa/users")
	public ResponseEntity<User> CreateUser(@Valid @RequestBody User user) {

		User savedUser = repository.save(user);
		// /jpa/users/4 => /jpa/users/{id}, user.getID
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()

				.path("/{id}").buildAndExpand(savedUser.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

	// DELETE /users/{id}
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		repository.deleteById(id);
	}

	// GET /users/{id}/posts
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrievePostsForUser(@PathVariable("id") int id) {
		User user = repository.findById(id).get();

		if (user == null) {
			throw new UserNotFoundException("id" + id);
		}

		return user.getPosts();
	}

	// POST /users/{id}/posts
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUser(@PathVariable("id") int id, @Valid @RequestBody Post post) {

		User user = repository.findById(id).get();

		if (user == null) {
			throw new UserNotFoundException("id" + id);
		}

		post.setUser(user);

		Post savedPost = postRepository.save(post);

		// /jpa/users/{id}/posts/{post_id}
		URI location = ServletUriComponentsBuilder.fromCurrentContextPath()

				.path("/{id}").buildAndExpand(savedPost.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
}
