package com.sample.todo.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import com.sample.todo.model.Todo;

@Repository
public class TodoDaoImpl implements TodoDao {

	private static AtomicInteger sequence = new AtomicInteger(10000001);
	private LinkedList<Todo> todos = new LinkedList<Todo>();
	
	public TodoDaoImpl() {
		todos.addFirst(new Todo(getSeq(), "연습1", "연습1입니다.", true, "2018-05-30"));
		todos.addFirst(new Todo(getSeq(), "연습2", "연습2입니다.", false, "2018-05-30"));
		todos.addFirst(new Todo(getSeq(), "연습3", "연습3입니다.", true, "2018-05-30"));
		todos.addFirst(new Todo(getSeq(), "연습4", "연습4입니다.", false, "2018-05-30"));
		todos.addFirst(new Todo(getSeq(), "연습5", "연습5입니다.", true, "2018-05-30"));
	}
	
	public int getSeq() {
		return sequence.getAndIncrement();
	}

	public void insertTodo(Todo todo) {
		todos.addFirst(todo);
	}

	public Todo getTodo(int no) {
		Iterator<Todo> it = todos.iterator();
		
		Todo savedTodo = null;
		while (it.hasNext()) {
			Todo item = it.next();
			if (item.getNo() == no) {
				savedTodo = item;
				break;
			}
		}
		return savedTodo;
	}
	
	public List<Todo> getTodos() {
		return todos;
	}

	public void deleteTodo(int no) {
		Iterator<Todo> it = todos.iterator();
		while (it.hasNext()) {
			Todo todo = it.next();
			if (todo.getNo() == no) {
				it.remove();
				break;
			}
		}
	}

	public void deleteAllTodos() {
		todos.clear();
	}

	public void updateTodo(Todo todo) {
		Iterator<Todo> it = todos.iterator();
		
		Todo savedTodo = null;
		while (it.hasNext()) {
			Todo item = it.next();
			if (item.getNo() == todo.getNo()) {
				savedTodo = item;
				break;
			}
		}
		
		BeanUtils.copyProperties(todo, savedTodo);
		
	}
}
