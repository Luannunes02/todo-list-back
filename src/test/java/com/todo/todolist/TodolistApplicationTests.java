package com.todo.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.todo.todolist.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucess() {
		var todo = new Todo("todo one", "desc todo 1", false, 1);

		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$.[0].name").isEqualTo(todo.getName())
			.jsonPath("$.[0].description").isEqualTo(todo.getDescription())
			.jsonPath("$.[0].realized").isEqualTo(todo.isRealized())
			.jsonPath("$.[0].priority").isEqualTo(todo.getPriority());
	}

	@Test
	void testCreateTodoFailure() {
		webTestClient
			.post()
			.uri("/todos")
			.bodyValue(new Todo("", "", false, 1))
			.exchange()
			.expectStatus().isBadRequest();
	}
}
