package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;

@Repository
public class CourseJpaRepository {

	private EntityManager entityManager;
}
