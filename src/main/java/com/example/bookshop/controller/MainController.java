package com.example.bookshop.controller;

import com.example.bookshop.domain.Book;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }


    @GetMapping("/shop")
    public String main(Model model) {

Iterable<Book> books = bookService.findAll();


     model.addAttribute("books",books);
        return "main";
    }
}
