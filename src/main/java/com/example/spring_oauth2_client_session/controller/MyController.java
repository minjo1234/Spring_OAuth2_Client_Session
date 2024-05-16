package com.example.spring_oauth2_client_session.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/my")
    public String myP(){
        return "my";
    }
}
