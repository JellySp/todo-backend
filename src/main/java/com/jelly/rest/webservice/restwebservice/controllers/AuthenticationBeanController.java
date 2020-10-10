package com.jelly.rest.webservice.restwebservice.controllers;
import com.jelly.rest.webservice.restwebservice.beans.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// allows requests from specified urls
@CrossOrigin(origins="http://localhost:4200")
@RestController //Spring Controller
public class AuthenticationBeanController {

    // @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/authentication")
    public String helloAuthentication() {
        return "Hello World!";
    }
    // hello-world-bean
    // gets magically (read: I don't know how) converted to JSON
    @GetMapping(path = "/authentication-bean")
    public AuthenticationBean helloAuthenticationBean() {

        return new AuthenticationBean("Hello AuthenticationBean -Change");
//        throw new RuntimeException("errorrr");
    }

    // /hello-world/path-variable/Jelly should display "Hello, Jelly!"
    @GetMapping(path = "/authentication/path-variable/{name}")
    public AuthenticationBean helloWorldPathVariable(@PathVariable String name) {
        return new AuthenticationBean(String.format("Hello, %s", name));
    }

//cant push
}
