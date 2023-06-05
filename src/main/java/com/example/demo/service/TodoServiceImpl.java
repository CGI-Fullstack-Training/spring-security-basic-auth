package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

	private TodoRepository todoRepository;

	@Override
	public Todo createTodo(Todo todo) {
		return todoRepository.save(todo);
	}

	@Override
	public Iterable<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	@Override
	public Todo findTodoById(int id) {
		Optional<Todo> t = todoRepository.findById(id);
		if (t.isPresent()) {
			return t.get();
		} else
			return null;

	}

	@Override
	public String deleteTodoById(int id) {
		Optional<Todo> todo = todoRepository.findById(id);
		if (todo.isPresent()) {
			todoRepository.deleteById(id);
			return "todo with id " + id + " deleted successfully";
		} else
			return "todo with id " + id + " not found";

	}

	@Override
	public Todo updateTodoById(int id, Todo todo) {
		Optional<Todo> todoFromDb = todoRepository.findById(id);

		if (todoFromDb.isPresent()) {
			Todo t = todoFromDb.get();
			t.setToDoName(todo.getToDoName());
			t.setIsCompleted(todo.getIsCompleted());
			return todoRepository.save(t);
		} else
			return null;
	}

}
