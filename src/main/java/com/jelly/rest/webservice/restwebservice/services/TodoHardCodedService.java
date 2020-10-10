package com.jelly.rest.webservice.restwebservice.services;

import com.jelly.rest.webservice.restwebservice.beans.TodoBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardCodedService {

    private static List<TodoBean> todos = new ArrayList<>();
    private static int idCounter = 0;

    static {
        todos.add(new TodoBean(++idCounter, "Jelly","Learn to dance", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Learn programming", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Quit programming and build a house", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Make footer scroll down", new Date(), false));
        todos.add(new TodoBean(++idCounter, "Jelly","Waffles", new Date(), false));

    }

    public List<TodoBean> findAll() {
        return todos;
    }

    public TodoBean saveTodo(TodoBean todo) {
        if (todo.getId() == -1 || todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);

        } else {
            deleteById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public TodoBean deleteById(long id) {
        TodoBean todo = findById(id);
        if(todo == null) {
            return null;
        }
        if (todos.remove(todo)) {
            return todo;
        }
        return null;
    }

    public TodoBean findById(long id) {
        for (TodoBean todo: todos) {
            if (todo.id == id) {
                return todo;
            }
        }
        return null;
    }


}
