package com.example.mobile.controller;

import com.example.mobile.dto.MemberFormDto;
import com.example.mobile.entity.Member;
import com.example.mobile.service.MobileService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "sub")
public class NoneMemberController {
    private final MobileService mobileService;
    private final PasswordEncoder passwordEncoder;

    /*회원가입 페이지*/
    @GetMapping("/new")
    public String mobileForm(Model model){
        model.addAttribute("mobileFormDto",new MemberFormDto());
        return "sub_page/login/join";
    }

    /*로그인 페이지*/

    @GetMapping("/login")
    public String loginMobile(){
        return "sub_page/login/login";
    }

    @PostMapping("/new")
    public String newMobile(@Valid MemberFormDto mobileFormDto, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "sub_page/login/join";
        }
        try{
            Member mobile = Member.createMobile(mobileFormDto, passwordEncoder);
            mobileService.saveMobile(mobile);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage",e.getMessage());
            return "sub_page/login/join";
        }
        return "redirect:/sub/login";
    }

    @GetMapping("/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg","아이디 또는 비밀번호를 확인해주세요.");
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
