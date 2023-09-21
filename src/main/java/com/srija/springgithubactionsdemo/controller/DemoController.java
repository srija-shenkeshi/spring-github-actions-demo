package com.srija.springgithubactionsdemo.controller;

import com.srija.springgithubactionsdemo.model.GetResponse;
import com.srija.springgithubactionsdemo.model.Request;
import com.srija.springgithubactionsdemo.model.Response;
import com.srija.springgithubactionsdemo.service.DemoService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
public class DemoController {

    @Autowired
    DemoService demoService;

    @SneakyThrows
    @PostMapping("/create")
    public ResponseEntity<Response> createUser(@RequestBody Request request){
        log.info("request body::: {}", request);
        Response response = null;
        if (!request.getUsername().isEmpty()) {
            response = demoService.createUserInDB(request);
        }

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.CREATED);
    }

    @SneakyThrows
    @GetMapping("/getUser/{username}")
    public ResponseEntity<GetResponse> getUser(@PathVariable String username){
        log.info("request body::: {}", username);
        GetResponse response = null;
        if (!username.isEmpty()) {
            response = demoService.getUser(username);
        }

        return new ResponseEntity<>(response, new HttpHeaders(), HttpStatus.OK);
    }

    @SneakyThrows
    @GetMapping("/hello")
    public ResponseEntity<String> getResponse(){
        return new ResponseEntity<>("Hey there!!", new HttpHeaders(), HttpStatus.OK);
    }
}
