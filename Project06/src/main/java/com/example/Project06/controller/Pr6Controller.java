package com.example.Project06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("aaa")
public class Pr6Controller {

    @GetMapping("*")
    public String showView(){
        return "index";
    }
    @GetMapping("sub01/login.html")
    public String showViewLogin(){
        return "sub01/login";
    }
    @GetMapping("sub02/board.html")
    public String showViewBoard(){
        return "sub02/board";
    }
    @GetMapping("sub03/info.html")
    public String showViewInfo(){
        return "sub03/info";
    }

    @GetMapping("sub04/sub4.html")
    public String showViewSub4(){
        return "sub04/sub4";
    }

    @GetMapping("sub05/popup.html")
    public String showViewPopup(){
        return "sub05/popup";
    }
}
