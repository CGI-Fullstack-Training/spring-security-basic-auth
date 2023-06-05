package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Completed;
import com.example.demo.model.Todo;
import com.example.demo.repository.TodoRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
public class TodoServiceSpringBasicSecurityApplication implements CommandLineRunner {

	private final TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoServiceSpringBasicSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		todoRepository.save(new Todo(1, "Compile", Completed.YES));
		todoRepository.save(new Todo(2, "Test", Completed.NO));
		todoRepository.save(new Todo(3, "CDeploy", Completed.NO));

	}

}
