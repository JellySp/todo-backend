package com.jelly.rest.webservice.restwebservice.beans;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table
public class UserBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String userRole;
    private String encodedPassword;

    @OneToMany
    private Set<TodoBean> todoBean;
}
