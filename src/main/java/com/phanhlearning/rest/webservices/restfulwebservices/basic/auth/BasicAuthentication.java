package com.phanhlearning.rest.webservices.restfulwebservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthentication {


    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean() {

        return new AuthenticationBean("You are authenticated");
    }}
