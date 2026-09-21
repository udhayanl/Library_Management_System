package com.example.library_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library_management_system.model.Member;
import com.example.library_management_system.services.MemberServices;

@RestController
@RequestMapping("/members")
public class MemberController {
    private final MemberServices services;

    public MemberController(MemberServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return services.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return services.getMemberById(id);
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return services.addMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member member) {
        return services.updateMember(id, member);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        services.deleteMember(id);
    }
}