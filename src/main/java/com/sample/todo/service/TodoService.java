package com.sample.todo.service;

import java.util.List;

import com.sample.todo.model.Todo;

public interface TodoService {

	void clearCompleted();
	void removeTodo(int no);
	List<Todo> getTodos();
	Todo getTodo(int no);
	void addTodo(Todo todo);
	void updateTodo(Todo todo);
}
