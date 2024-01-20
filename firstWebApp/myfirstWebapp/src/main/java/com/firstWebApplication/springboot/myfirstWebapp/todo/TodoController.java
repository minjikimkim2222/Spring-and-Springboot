package com.firstWebApplication.springboot.myfirstWebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	// add-todo - GET
	@RequestMapping(value = "/add-todo", method = RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {

		String username = (String) model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false); // 새로운 Todo를 생성할 때마다의 디폴트 todo
		model.put("todo", todo);
		return "addTodo";
	}

	// add-todo - POST
	@RequestMapping(value = "/add-todo", method = RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, Todo todo) {

		String username = (String) model.get("name");
		todoService.AddTodo(username, todo.getDescription(), LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
}
