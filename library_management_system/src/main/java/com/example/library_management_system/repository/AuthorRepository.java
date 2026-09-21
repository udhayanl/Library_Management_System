package com.example.library_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.library_management_system.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    //Author is the entity class object that we want to perform CRUD operations on
    //Long datatype is for the primary key of the Author entity, which is of type Long 
}