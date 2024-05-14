package com.example.mobile_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/members")
@Controller
public class MyPageController {
    @GetMapping("/my")
    public String search_page(){
        return "sub_page/my/my";
    }

    @GetMapping("/my_pick")
    public String search_info_recipe_page(){
        return "sub_page/my/my_pick";
    }
}
