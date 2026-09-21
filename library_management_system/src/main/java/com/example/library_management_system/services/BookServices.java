package com.example.library_management_system.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.library_management_system.model.Book;
import com.example.library_management_system.repository.BookRepository;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null");
        }
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null");
        }
        if (updatedBook == null) {
            throw new IllegalArgumentException("Updated book cannot be null");
        }

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setAuthor(updatedBook.getAuthor());
        existingBook.setPrice(updatedBook.getPrice());

        return bookRepository.save(existingBook);
    }

    public void deleteBook(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Book id cannot be null");
        }

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        bookRepository.delete(existingBook);
    }
}