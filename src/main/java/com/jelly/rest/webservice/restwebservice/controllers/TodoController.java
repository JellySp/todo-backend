package com.jelly.rest.webservice.restwebservice.controllers;

import com.jelly.rest.webservice.restwebservice.beans.TodoBean;
import com.jelly.rest.webservice.restwebservice.services.TodoHardCodedService;
import org.apache.catalina.security.SecurityConfig;
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
public class TodoController {

    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<TodoBean> getAllTodos(@PathVariable String username) {
        return todoService.findAll();
    }

    @GetMapping("/users/{username}/todos/{id}")
    public TodoBean getTodo(@PathVariable String username, @PathVariable long id) {
        return todoService.findById(id);
    }

    // ResponseEntity is needed if there are many statuses. In this case for no content or not found
    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        TodoBean todo = todoService.deleteById(id);
        if (todo == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<TodoBean> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody TodoBean todo) {
        TodoBean todoUpdated = todoService.saveTodo(todo);
        return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody TodoBean todo) {
        TodoBean createdTodo = todoService.saveTodo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(createdTodo.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }


}
