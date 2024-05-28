package com.example.mobile.controller;

import com.example.mobile.dto.MemberFormDto;
import com.example.mobile.entity.Member;
import com.example.mobile.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequiredArgsConstructor
@RequestMapping(value = "user")
public class MemberController {
    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @GetMapping("/my")
    public String my_page(Model model, @AuthenticationPrincipal User user){
        model.addAttribute("nm", memberService.getNameByEmail(user.getUsername()));

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

    @GetMapping(value = "/delete")
    public String delete(@AuthenticationPrincipal User user){
        memberService.deleteByEmail(user.getUsername());
        return "redirect:/sub/logout";
    }

    @GetMapping("/update")
    public String updatePage(Model model,@AuthenticationPrincipal User user){
        model.addAttribute("memberFormDto", memberService.getMobile(user.getUsername()));
        return "sub_page/login/update_page";
    }

    @PostMapping("/update")
    public String newMobile(@Valid MemberFormDto memberFormDto, Model model, @AuthenticationPrincipal User user){
        String email = user.getUsername();
        memberService.deleteByEmail(email);

        Member mobile = Member.createMember(memberFormDto, passwordEncoder);

        memberService.updateMobile(mobile);
        return "redirect:/user/my";
    }
}
