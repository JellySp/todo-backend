package com.jelly.rest.webservice.restwebservice.beans;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

@Data
public class TodoBean {


    public TodoBean(long id, String username, String description, Date targetDate, boolean isDone) {
        this.id = id;
        this.username = username;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = isDone;
    }

    public long id;
    private String username;
    private String description;
    private Date targetDate;
    private boolean isDone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoBean)) return false;
        TodoBean todoBean = (TodoBean) o;
        return id == todoBean.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
