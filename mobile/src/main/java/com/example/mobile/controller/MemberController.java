package com.example.mobile.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class MemberController {
    @GetMapping("/my")
    public String my_page(){
        return "sub_page/my/my";
    }

    @GetMapping("/my_pick")
    public String my_pick_page(){
        return "sub_page/my/my_pick";
    }

    @GetMapping("/recipe_write")
    public String recipe_write_page(){
        return "sub_page/my/recipe_write";
    }
}
