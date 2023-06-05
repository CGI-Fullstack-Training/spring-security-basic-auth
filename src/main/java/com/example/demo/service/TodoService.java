package com.example.demo.service;

import com.example.demo.model.Todo;

public interface TodoService {
	public Todo createTodo(Todo todo);
	public Iterable<Todo> getAllTodos();
	public Todo findTodoById(int id);
	public String deleteTodoById(int id);
	public Todo updateTodoById(int id,Todo todo);

}
