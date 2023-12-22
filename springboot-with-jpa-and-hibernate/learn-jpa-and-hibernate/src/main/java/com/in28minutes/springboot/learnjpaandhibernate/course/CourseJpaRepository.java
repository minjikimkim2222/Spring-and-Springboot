package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJpaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	public void insert(Course course) {
		entityManager.merge(course);
	}

	public Course findById(int id) {
		return entityManager.find(Course.class, id); // Course.class에서 id를 통해 찾아내자
	}

	public void deleteById(int id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}
}
