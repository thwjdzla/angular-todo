package com.sample.todo.dao;

import java.util.List;

import com.sample.todo.model.Todo;

public interface TodoDao {

	int getSeq();
	void insertTodo(Todo todo);
	List<Todo> getTodos();
	void deleteTodo(int no);
	void deleteAllTodos();
	void updateTodo(Todo todo);
	Todo getTodo(int no);
}
