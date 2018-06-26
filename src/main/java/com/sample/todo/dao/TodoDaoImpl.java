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
		todos.addFirst(new Todo(getSeq(), "장보기", "연습1입니다.", true, "2018-06-10"));
		todos.addFirst(new Todo(getSeq(), "코드 리뷰하기", "연습2입니다.", false, "2018-06-02"));
		todos.addFirst(new Todo(getSeq(), "프로젝트 시연 준비하기", "연습3입니다.", true, "2018-06-24"));
		todos.addFirst(new Todo(getSeq(), "조별 회의 참관하기", "연습4입니다.", false, "2018-06-05"));
		todos.addFirst(new Todo(getSeq(), "할일1", "연습10입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일2", "연습11입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일3", "연습12입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일4", "연습13입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일5", "연습14입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일6", "연습15입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일7", "연습16입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일8", "연습17입니다.", true, "2018-06-13"));
		todos.addFirst(new Todo(getSeq(), "할일9", "연습18입니다.", true, "2018-06-13"));
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
