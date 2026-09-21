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

import com.example.library_management_system.model.Book;
import com.example.library_management_system.services.BookServices;


@RestController
@RequestMapping("/books")
public class BookController {
    private final BookServices services;

    public BookController(BookServices services) {
        this.services = services;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return services.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return services.getBookById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return services.addBook(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        return services.updateBook(id, book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        services.deleteBook(id);
    }

}