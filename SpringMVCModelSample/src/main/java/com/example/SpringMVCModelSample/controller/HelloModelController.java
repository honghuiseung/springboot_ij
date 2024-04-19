package com.example.SpringMVCModelSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloModelController {
    //@GetMapping("aaa")//주소창에 aaa를 치면 동작
    @GetMapping("model")
    public String helloView(Model model){ //model : spring에서 제공하는 model
        model.addAttribute("msg","타임리프!!!");//모델을 사용하면 반드시 나오는 메소드
        model.addAttribute("name","길동");
        //return "helloThymeleaf";
        return "useThymeleaf";
    }
}
