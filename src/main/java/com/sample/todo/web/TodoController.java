package com.sample.todo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.todo.model.Todo;
import com.sample.todo.service.TodoService;

@Controller 
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/")
	public String home() {
		return "index.html";
	}
	
	@RequestMapping("/todos/")
	@ResponseBody
	public List<Todo> todos() {
		return todoService.getTodos();
	}
	
	@RequestMapping("/todos/{todoNo}")
	@ResponseBody
	public Todo todo(@PathVariable("todoNo") int todoNo) {
		return todoService.getTodo(todoNo);
	}
}
