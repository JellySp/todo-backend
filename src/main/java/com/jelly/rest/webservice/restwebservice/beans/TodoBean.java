package com.jelly.rest.webservice.restwebservice.beans;

import lombok.Data;

import java.util.Date;

@Data
public class TodoBean {
    public TodoBean(long id, String username, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    private long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

}
