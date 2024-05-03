package com.example.Project06.controller;

import com.example.Project06.entity.Board;
import com.example.Project06.form.BoardForm;
import com.example.Project06.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping
public class Pr6Controller {

    @Autowired
    BoardService service;
    private String boardSize;

    @GetMapping
    public String showView(){
        return "index";
    }
    @GetMapping("sub01/login.html")
    public String showViewLogin(){
        return "sub01/login";
    }

    @GetMapping("sub02/board.html")
    public String showViewBoard(BoardForm boardForm, Model model){
        boardForm.setNewBoard(true);
        boardSize = service.getSizeOfBoard().toString();
        Iterable<Board> list = service.selectReverseAll();

        model.addAttribute("boardSize", boardSize);
        model.addAttribute("list", list);
        model.addAttribute("title", "등록 폼");

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
