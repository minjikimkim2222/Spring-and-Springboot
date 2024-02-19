package com.firstWebApplication.springboot.myfirstWebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {

	private TodoRepository todoRepository;

	@Autowired
	public TodoControllerJpa(TodoRepository todoRepository) {
		super();
		this.todoRepository = todoRepository;
	}

	// list-todos
	@RequestMapping("/list-todos")
	public String listAllTodos(ModelMap model) {

		String username = (String) getLoggedInUsername(model);

		List<Todo> todos = todoRepository.findByUsername(username);

		model.addAttribute("todos", todos);

		return "listTodos";
	}

	// add-todo - GET
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {

		String username = (String) getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false); // 새로운 Todo를 생성할 때마다의
																					// 디폴트 todo
		model.put("todo", todo); // model scope == request URL scope이기에 /add-todo에만 해당 모델값이 유지된다.

		return "addTodo";
	}

	// add-todo - POST
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}
		String username = (String) getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);

		return "redirect:list-todos";
	}

	// delete-todo
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {

		// Delete todo
		todoRepository.deleteById(id);
		// 삭제된 todo를 보여주는 redirect:list-todos
		return "redirect:list-todos";
	}

	// update-todo - GET
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoRepository.findById(id).get();
		model.put("todo", todo);
		return "addTodo";
	}

	// update-todo - POST
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}

		String username = (String) getLoggedInUsername(model);
		todo.setUsername(username);
		todoRepository.save(todo);

		return "redirect:list-todos";
	}

	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication

				= SecurityContextHolder.getContext().getAuthentication();

		return authentication.getName();
	}
}
