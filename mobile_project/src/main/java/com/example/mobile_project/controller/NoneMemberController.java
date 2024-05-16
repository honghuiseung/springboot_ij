package com.example.mobile_project.controller;

import com.example.mobile_project.dto.MemberFormDto;
import com.example.mobile_project.entity.Member;
import com.example.mobile_project.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sub")
@Controller
@RequiredArgsConstructor
public class NoneMemberController {
    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    /*회원가입 페이지*/

    @GetMapping(value = "/new")
    public String memberForm(Model model){
        model.addAttribute("memberFormDto", new MemberFormDto());
        return "sub_page/login/join";
    }

    /*로그인 페이지*/

    @GetMapping(value = "/login")
    public String login(){
        return "sub_page/login/login";
    }

    @PostMapping(value="/new")
    public String newMember(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model){//제약사항을 받아오는 어노테이션

        if(bindingResult.hasErrors()){
            return "sub_page/login/join";
        }

        try{
            Member member = Member.createMember(memberFormDto, passwordEncoder);
            memberService.saveMember(member);
        } catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "sub_page/login/join";
        }

        return "redirect:/sub/login";
    }

    @GetMapping(value = "/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "redirect:/sub/login";
    }
    
    /*레시피 페이지*/

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

    /*검색 페이지*/
    
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
