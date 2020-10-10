package com.jelly.rest.webservice.restwebservice.interfaces;

import com.jelly.rest.webservice.restwebservice.beans.TodoBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJPARepository extends JpaRepository<TodoBean, Long>{
    List<TodoBean> findByUsername(String username);
}
