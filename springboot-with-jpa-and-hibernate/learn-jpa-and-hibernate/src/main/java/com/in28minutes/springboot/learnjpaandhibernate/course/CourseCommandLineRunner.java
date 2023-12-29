package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		repository.save(new Course(2, "db", "minji2"));
		repository.save(new Course(3, "java", "minji3"));
		repository.save(new Course(4, "spring", "minji4"));

		repository.deleteById(2l);

		System.out.println(repository.findById(4l));
		System.out.println(repository.findById(3l));

		System.out.println(repository.findAll());

		System.out.println("how many entities " + repository.count());

		System.out.println("findByAuthor test " + repository.findByAuthor("minji3"));
		System.out.println("findByAuthor test2 " + repository.findByAuthor(""));
	}

}
