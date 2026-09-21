package com.example.library_management_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library_management_system.model.Member;
import com.example.library_management_system.repository.MemberRepository;

@Service
public class MemberServices {

    private final MemberRepository memberRepository;

    public MemberServices(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Member id cannot be null");
        }
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
    }

    public Member addMember(Member member) {
        if (member == null) {
            throw new IllegalArgumentException("Member cannot be null");
        }
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member updatedMember) {
        if (id == null) {
            throw new IllegalArgumentException("Member id cannot be null");
        }
        if (updatedMember == null) {
            throw new IllegalArgumentException("Updated member cannot be null");
        }

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));

        existingMember.setName(updatedMember.getName());
        existingMember.setEmail(updatedMember.getEmail());
        existingMember.setPhoneNumber(updatedMember.getPhoneNumber());

        return memberRepository.save(existingMember);
    }

    public void deleteMember(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Member id cannot be null");
        }

        Member existingMember = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + id));
        memberRepository.delete(existingMember);
    }
}