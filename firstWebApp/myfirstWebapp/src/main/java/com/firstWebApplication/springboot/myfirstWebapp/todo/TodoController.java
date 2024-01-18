package com.firstWebApplication.springboot.myfirstWebapp.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
}
