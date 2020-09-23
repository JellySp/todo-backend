package com.jelly.rest.webservice.restwebservice.controllers;

import com.jelly.rest.webservice.restwebservice.beans.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// allows requests from specified urls
@CrossOrigin(origins="http://localhost:4200")
@RestController //Spring Controller
public class HelloWorldController {

    // @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }
    // hello-world-bean
    // gets magically (read: I don't know how) converted to JSON
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {

        return new HelloWorldBean("Hello World! -Change");
//        throw new RuntimeException("errorrr");
    }

    // /hello-world/path-variable/Jelly should display "Hello, Jelly!"
    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello, %s", name));
    }

//cant push
}
