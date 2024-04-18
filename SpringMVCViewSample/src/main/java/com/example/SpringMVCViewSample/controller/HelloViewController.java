package com.example.SpringMVCViewSample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
//@RequestMapping(value = "hello")
//@RequestMapping(value = { "hello", "hellospring" })
//@RequestMapping(value =  "hello", method = RequestMethod.GET)
//@RequestMapping(value =  "hello", method = { RequestMethod.GET, RequestMethod.POST })
public class HelloViewController {

    @GetMapping("view")
    //@GetMapping( value = { "hello", "hellospring" })
    public String helloView(){
        return "hello";
    }
    @GetMapping("view2")
    public String morningView(){
        return "morning";
    }
}
//문제1) http://localhost:8080/hello/view2를 입력하면 morning가 출력되게 만들어 보세요.
//문제2) http://localhost:8080/hello/view2 또는 view를 입력하면 Hello View!!!가 출력되게 만들어 보세요.