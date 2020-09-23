package com.jelly.rest.webservice.restwebservice.controllers;

import com.jelly.rest.webservice.restwebservice.beans.TodoBean;
import com.jelly.rest.webservice.restwebservice.services.TodoHardCodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {

    @Autowired
    private TodoHardCodedService todoService;

    @GetMapping("/users/{username}/todos")
    public List<TodoBean> getAllTodos(@PathVariable String username) {
        return todoService.findAll();

    }
}
