package com.jelly.rest.webservice.restwebservice.controllers;

import com.jelly.rest.webservice.restwebservice.beans.TodoBean;
import com.jelly.rest.webservice.restwebservice.interfaces.TodoJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping
public class TodoJPAController {

    @Autowired
    private TodoJPARepository todoJPARepository;

    @GetMapping("/jpa/users/{username}/todos")
    public List<TodoBean> getAllTodos(@PathVariable String username) {
        return todoJPARepository.findByUsername(username);
    }

    @GetMapping("/jpa/users/{username}/todos/{id}")
    public TodoBean getTodo(@PathVariable String username, @PathVariable long id) {
        return todoJPARepository.findById(id).get();

    }

    // ResponseEntity is needed if there are many statuses. In this case for no content or not found
    @DeleteMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        todoJPARepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jpa/users/{username}/todos/{id}")
    public ResponseEntity<TodoBean> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TodoBean todo) {
        todo.setUsername(username);
        TodoBean todoUpdated = todoJPARepository.save(todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/jpa/users/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody TodoBean todo) {
        TodoBean createdTodo = todoJPARepository.save(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


}
