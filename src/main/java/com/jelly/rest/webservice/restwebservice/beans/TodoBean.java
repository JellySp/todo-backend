package com.jelly.rest.webservice.restwebservice.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@NoArgsConstructor
@Table
public class TodoBean {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

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
