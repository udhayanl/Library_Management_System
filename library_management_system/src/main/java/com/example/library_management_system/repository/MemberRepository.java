package com.example.library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library_management_system.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    //Member is the entity class object that we want to perform CRUD operations on
    //Long datatype is for the primary key of the Member entity, which is of type Long 
}