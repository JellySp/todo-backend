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
    }

    public List<TodoBean> findAll() {
        return todos;
    }
}
