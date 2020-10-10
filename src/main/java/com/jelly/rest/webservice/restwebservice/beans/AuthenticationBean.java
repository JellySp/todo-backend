package com.jelly.rest.webservice.restwebservice.beans;
import lombok.Data;

@Data
public class AuthenticationBean {

    private final String message;

    public AuthenticationBean(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return String.format("HelloWorldBean [message=%s]", message);
    }
}
