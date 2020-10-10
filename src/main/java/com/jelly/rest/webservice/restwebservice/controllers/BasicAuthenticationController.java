package com.jelly.rest.webservice.restwebservice.controllers;

import com.jelly.rest.webservice.restwebservice.beans.AuthenticationBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// allows requests from specified urls
@CrossOrigin(origins="http://localhost:4200")
@RestController //Spring Controller
public class BasicAuthenticationController {

    // @RequestMapping(method = RequestMethod.GET, path="/hello-world")
    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {

        return new AuthenticationBean("Authentication successful!");

    }


}
