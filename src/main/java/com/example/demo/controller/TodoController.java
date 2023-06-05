package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/todos")
public class TodoController {

	private final TodoService todoService;

	@PostMapping
	public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createTodo(todo));
	}

	@GetMapping
	public ResponseEntity<Iterable<Todo>> getAllTodos() {
		return ResponseEntity.status(HttpStatus.OK).body(todoService.getAllTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findTodoById(@PathVariable("id") int id) {
		Todo todo = todoService.findTodoById(id);
		if (todo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Todo with id " + id + " not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(todo);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTodoById(@PathVariable("id") int id) {

		return ResponseEntity.status(HttpStatus.OK).body(todoService.deleteTodoById(id));

	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateTodoById(@PathVariable("id") int id, @RequestBody Todo todo) {

		return ResponseEntity.status(HttpStatus.OK).body(todoService.updateTodoById(id,todo));

	}

}
