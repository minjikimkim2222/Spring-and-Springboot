package com.firstWebApplication.springboot.myfirstWebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class TodoController {

	private TodoService todoService;

	@Autowired
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	// list-todos
	@RequestMapping("/list-todos")
	public String listAllTodos(ModelMap model) {

		List<Todo> todos = todoService.findByUsername("minjiki2");

		model.addAttribute("todos", todos);

		return "listTodos";
	}

	// add-todo - GET
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {

		String username = (String) model.get("name");
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
		String username = (String) model.get("name");
		todoService.AddTodo(username, todo.getDescription(), todo.getDeadline(), false);
		return "redirect:list-todos";
	}

	// delete-todo
	@RequestMapping("/delete-todo")
	public String deleteTodo(@RequestParam int id) {

		// Delete todo
		todoService.deleteById(id);
		// 삭제된 todo를 보여주는 redirect:list-todos
		return "redirect:list-todos";
	}

	// update-todo - GET
	@RequestMapping(value = "/update-todo", method = RequestMethod.GET)
	public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {

		Todo todo = todoService.findById(id);
		model.put("todo", todo);
		return "addTodo";
	}

	// update-todo - POST
	@RequestMapping(value = "/update-todo", method = RequestMethod.POST)
	public String updateNewTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {

		if (result.hasErrors()) {
			return "addTodo";
		}

		String username = (String) model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
