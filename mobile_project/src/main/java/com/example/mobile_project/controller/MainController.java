package com.example.mobile_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/")
    public String main(){
        return "index";
    }

    @GetMapping(value = "/login")
    public String login(){
        return "sub_page/login/login";
    }

    @GetMapping(value = "/join")
    public String join(){
        return "sub_page/login/join";
    }
}
