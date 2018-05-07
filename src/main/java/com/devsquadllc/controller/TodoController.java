package com.devsquadllc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.devsquadllc.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	private TodoService todoSvc;
	
	@GetMapping("/")
	public String showIndexPage() {
		return "index";
	}
	
	@GetMapping("/user")
	public String showUserPage(ModelMap model) {
		model.put("todos",todoSvc.getTodoList());
		return "user";
	}
	
	@PostMapping("/user/saveTodo")
	public String saveTodo(@RequestParam String description) {
		todoSvc.saveTodo(description);
		return "redirect:/user";
	}
	
	@PostMapping("/user/{id}")
	public String deleteTodo(@PathVariable long id) {
		todoSvc.deleteTodoById(id);
		return "redirect:/user";
	}

}
