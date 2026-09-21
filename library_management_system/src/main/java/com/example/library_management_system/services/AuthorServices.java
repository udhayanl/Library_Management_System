package com.example.library_management_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library_management_system.model.Author;
import com.example.library_management_system.repository.AuthorRepository;

@Service
public class AuthorServices {

    private final AuthorRepository authorRepository;

    public AuthorServices(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public Author getAuthorById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Author id cannot be null");
        }
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public Author addAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        return authorRepository.save(author);
    }

    public Author updateAuthor(Long id, Author updatedAuthor) {
        if (id == null) {
            throw new IllegalArgumentException("Author id cannot be null");
        }
        if (updatedAuthor == null) {
            throw new IllegalArgumentException("Updated author cannot be null");
        }

        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));

        existingAuthor.setName(updatedAuthor.getName());
        existingAuthor.setCountry(updatedAuthor.getCountry());

        return authorRepository.save(existingAuthor);
    }

    public void deleteAuthor(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Author id cannot be null");
        }

        Author existingAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
        authorRepository.delete(existingAuthor);
    }

}