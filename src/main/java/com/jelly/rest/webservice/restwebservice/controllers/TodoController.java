package com.jelly.rest.webservice.restwebservice.controllers;
import com.jelly.rest.webservice.restwebservice.beans.TodoBean;
import com.jelly.rest.webservice.restwebservice.services.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
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


}
