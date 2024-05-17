package com.example.mobile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value="/")
    public String main(){
        return "index";
    }

    @GetMapping("/onboarding")
    public String onboarding(){
        return "onboarding/onboarding";
    }

}