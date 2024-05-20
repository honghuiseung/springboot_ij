package com.example.mobile.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;

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

    @GetMapping(value = "/err")
    public String errorPage(){
        return "redirect:/";
    }

}
