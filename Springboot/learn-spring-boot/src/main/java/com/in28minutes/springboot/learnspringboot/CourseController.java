package com.in28minutes.springboot.learnspringboot;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	// http://localhost:8080/courses
	// course : id, name, author

	/*
	 * http://localhost:8080/courses
	 * 
	 * { "id": 1, "name": "Learn AWS", "author": "in28minutes" }
	 * 
	 * ]
	 */

	@RequestMapping("/courses")
	public List<Course> retriveAllCourses() {

		return Arrays.asList(

				new Course(1, "Learn AWS", "in28minutes"),

				new Course(2, "Learn DevOps", "in28minutes"),

				new Course(3, "Learn Azure", "in28minutes")

		);
	}
}