package com.firstWebApplication.springboot.myfirstWebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();

	private static int todosCount = 0;

	// static 변수 초기화를 위해서는, static 블럭이 필요.
	static {
		todos.add(new Todo(++todosCount, "minjiki2", "Learn springboot",

				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "minjiki2", "Learn db",

				LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todosCount, "minjiki2", "Learn algorithm",

				LocalDate.now().plusYears(2), false));

	}

	public List<Todo> findByUsername(String userName) {
		return todos;
	}

	public void AddTodo(String username, String description, LocalDate deadline, boolean done) {

		Todo todo = new Todo(++todosCount, username, description, deadline, done);
		todos.add(todo);

	}

	public void deleteById(int id) {

		// 람다 함수 x -> y : todo -> todo.getId() == id
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;

		todos.removeIf(predicate);
	}
}
