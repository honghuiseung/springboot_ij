package com.example.mobile_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sub")
@Controller
public class RecipePageController {
    @GetMapping("/recipe")
    public String recipe_page(){
        return "sub_page/recipe/recipe";
    }

    @GetMapping("/recipe2_1")
    public String recipe2_1_page(){
        return "sub_page/recipe/recipe2_1";
    }

    @GetMapping("/recipe2_2")
    public String recipe2_2_page(){
        return "sub_page/recipe/recipe2_2";
    }

    @GetMapping("/recipe3")
    public String recipe3_page(){
        return "sub_page/recipe/recipe3";
    }
}
