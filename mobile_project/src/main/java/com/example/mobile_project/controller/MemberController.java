package com.example.mobile_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class MemberController {

    @GetMapping("/my")
    public String my_page(){
        return "sub_page/my/my";
    }

    @GetMapping("/my_pick")
    public String my_pick_page(){
        return "sub_page/my/my_pick";
    }
}
