package com.example.mobile_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sub")
@Controller
public class SearchPageController {
    @GetMapping("/search")
    public String search_page(){
        return "sub_page/search/search";
    }

    @GetMapping("/search_info_recipe")
    public String search_info_recipe_page(){
        return "sub_page/search/search_info_recipe";
    }

    @GetMapping("/search_map")
    public String search_map_page(){
        return "sub_page/search/search_map";
    }

    @GetMapping("/product_detail")
    public String product_detail_page(){
        return "sub_page/search/product_detail";
    }
}
