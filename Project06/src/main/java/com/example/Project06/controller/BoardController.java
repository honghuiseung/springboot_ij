package com.example.Project06.controller;

import com.example.Project06.entity.Board;
import com.example.Project06.form.BoardForm;
import com.example.Project06.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardService service;
    private Integer deleteId;

    @ModelAttribute
    public BoardForm setUpForm() {
        BoardForm form = new BoardForm();
        return form;
    }


    @GetMapping("/board_list")
    public String showList(BoardForm boardForm, Model model){
        boardForm.setNewBoard(true);
        Iterable<Board> list = service.selectAll();

        model.addAttribute("list", list);
        model.addAttribute("title", "등록 폼");

        return "sub02/board_list";
    }

    @GetMapping("/board_crud")
    public String showCrud(BoardForm boardForm, Model model){
        boardForm.setNewBoard(true);
        Iterable<Board> list = service.selectAll();

        model.addAttribute("list", list);
        model.addAttribute("title", "등록 폼");

        return "sub02/board_crud";
    }

    @PostMapping("/insert")
    public String insert(@Validated BoardForm boardForm, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        Board board = new Board();
        board.setSeparate(boardForm.getSeparate());
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        board.setBoardnum(service.selectLastBn()+1);

        LocalDate localDate = LocalDate.now();
        board.setRegdate(localDate);

        if(!bindingResult.hasErrors()){
            service.insertBoard(board);
            redirectAttributes.addFlashAttribute("complete", "등록이 완료되었습니다.");
            return "redirect:/board/board_list";
        } else {
            return showCrud(boardForm, model);
        }

    }
    @GetMapping("/{id}")
    public String showUpdate(BoardForm boardForm, @PathVariable Integer id, Model model) {
        Optional<Board> BoardOpt = service.selectOneById(id);
        Optional<BoardForm> BoardFormOpt = BoardOpt.map(t -> makeBoardForm(t));
        if(BoardFormOpt.isPresent()){
            boardForm = BoardFormOpt.get();
        }
        makeUpdateModel(boardForm, model);
        return "sub02/board_crud";
    }

    @PostMapping("/delete")
    private String delete(@RequestParam("id") String id,
                          Model model,
                          RedirectAttributes redirectAttributes){
        service.deleteBoardById(Integer.parseInt(id));
        redirectAttributes.addFlashAttribute("delcomplete","삭제 완료했습니다.");
        return "redirect:/board/board_list";
    }

    private void makeUpdateModel(BoardForm boardForm, Model model){
        model.addAttribute("id", boardForm.getId());
        boardForm.setNewBoard(false);
        model.addAttribute("boardForm", boardForm);
        model.addAttribute("title", "변경 폼");
    }
    @PostMapping("/update")
    public String update(@Validated BoardForm boardForm,
                         BindingResult result,
                         Model model,
                         RedirectAttributes redirectAttributes){
        Board board = makeBoard(boardForm);
        if(!result.hasErrors()){
            service.updateBoard(board);
            redirectAttributes.addFlashAttribute("complete","변경이 완료되었습니다.");
            return "redirect:/board/" + board.getId();
        }else{
            makeUpdateModel(boardForm, model);
            return "sub02/board_crud" ;
        }
    }

    private Board makeBoard(BoardForm boardForm){
        Board board= new Board();
        board.setId(boardForm.getId());
        board.setSeparate(boardForm.getSeparate());
        board.setTitle(boardForm.getTitle());
        board.setContent(boardForm.getContent());
        board.setRegdate(boardForm.getRegdate());
        board.setBoardnum(boardForm.getBoardnum());
        return board;
    }

    private BoardForm makeBoardForm(Board board){
        BoardForm form= new BoardForm();
        form.setId(board.getId());
        form.setSeparate(board.getSeparate());
        form.setTitle(board.getTitle());
        form.setContent(board.getContent());
        form.setRegdate(board.getRegdate());
        form.setBoardnum(board.getBoardnum());
        form.setNewBoard(false);
        return form;
    }
}
