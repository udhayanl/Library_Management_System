package com.example.library_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library_management_system.model.Member;
import com.example.library_management_system.services.MemberServices;

@Controller
@RequestMapping("/member-view")
public class MemberWebController {

    private final MemberServices memberService;

    public MemberWebController(MemberServices memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public String showMembers(Model model) {
        model.addAttribute("members", memberService.getAllMembers());
        return "member";
    }

    @GetMapping("/new")
    public String showAddMemberForm(Model model) {
        model.addAttribute("member", new Member());
        return "add_member";
    }

    @PostMapping("/save")
    public String saveMember(@ModelAttribute("member") Member member) {
        memberService.addMember(member);
        return "redirect:/member-view";
    }

    @GetMapping("/edit/{id}")
    public String showEditMemberForm(@PathVariable Long id, Model model) {
        model.addAttribute("member", memberService.getMemberById(id));
        return "edit_member";
    }

    @PostMapping("/update/{id}")
    public String updateMember(@PathVariable Long id,
                               @ModelAttribute("member") Member member) {
        memberService.updateMember(id, member);
        return "redirect:/member-view";
    }

    @GetMapping("/delete/{id}")
    public String deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return "redirect:/member-view";
    }
}