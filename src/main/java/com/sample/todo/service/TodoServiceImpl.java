package com.sample.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.todo.dao.TodoDao;
import com.sample.todo.model.Todo;

@Service
public class TodoServiceImpl implements TodoService {

	@Autowired
	private TodoDao todoDao;
	
	public void clearCompleted() {
		todoDao.deleteAllTodos();
	}

	public void removeTodo(int no) {
		todoDao.deleteTodo(no);
	}

	public Todo getTodo(int no) {
		return todoDao.getTodo(no);
	}
	
	public List<Todo> getTodos() {
		return todoDao.getTodos();
	}

	public void addTodo(Todo todo) {
		int sequence = todoDao.getSeq();
		todo.setNo(sequence);
		
		todoDao.insertTodo(todo);
	}

	public void updateTodo(Todo todo) {
		todoDao.updateTodo(todo);
	}

	
}
