package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;

	@Autowired
	private CourseJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.insert(new Course(2, "db", "minji2"));
		repository.insert(new Course(3, "java", "minji3"));
		repository.insert(new Course(4, "spring", "minji4"));

		repository.deleteById(2);

		System.out.println(repository.findById(4));
		System.out.println(repository.findById(3));

	}

}
