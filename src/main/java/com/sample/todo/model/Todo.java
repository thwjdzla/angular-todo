package com.sample.todo.model;

public class Todo {

	private int no;
	private String title;
	private String description;
	private boolean isCompleted;
	private String eventDate;
	
	public Todo() {}
	
	public Todo(int no, String title, String description, boolean isCompleted, String eventDate) {
		super();
		this.no = no;
		this.title = title;
		this.description = description;
		this.isCompleted = isCompleted;
		this.eventDate = eventDate;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isCompleted() {
		return isCompleted;
	}
	public void setCompleted(boolean isCompleted) {
		this.isCompleted = isCompleted;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	
}
