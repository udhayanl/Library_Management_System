package com.example.library_management_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.library_management_system.model.Author;
import com.example.library_management_system.services.AuthorServices;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/author-view")
public class AuthorWebController {

    private final AuthorServices authorService;

    public AuthorWebController(AuthorServices authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public String showAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "author";
    }

    @GetMapping("/new")
    public String showAddAuthorForm(Model model) {
        model.addAttribute("author", new Author());
        return "add_author";
    }

    @PostMapping("/save")
    public String saveAuthor(@Valid @ModelAttribute("author") Author author,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "add_author";
        }

        authorService.addAuthor(author);
        return "redirect:/author-view";
    }

    @GetMapping("/edit/{id}")
    public String showEditAuthorForm(@PathVariable Long id, Model model) {
        model.addAttribute("author", authorService.getAuthorById(id));
        return "edit_author";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id,
                               @Valid @ModelAttribute("author") Author author,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "edit_author";
        }

        authorService.updateAuthor(id, author);
        return "redirect:/author-view";
    }

    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/author-view";
    }
}
