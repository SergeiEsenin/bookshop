package com.example.bookshop.controller;

import com.example.bookshop.domain.Book;
import com.example.bookshop.domain.Genre;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")

    public String greeting() {
        return "greeting";
    }

    @GetMapping("/test")
    public String gr() {
        return "test1";
    }

    @GetMapping("/shop")
    public String main(Model model) {

Iterable<Book> books = bookService.findAll();


     model.addAttribute("books",books);
        return "main";
    }
    @GetMapping("/shop/priceUp")
    public String filterPriceUp(Model model) {

        List<Book> books = bookService.findAll();
Collections.sort(books, Comparator.comparing(Book::getPrice));
        model.addAttribute("books",books);
        return "main";
    }
    @GetMapping("/shop/priceDown")
    public String filterPriceDown(Model model) {

        Iterable<Book> books = bookService.findAll();


        model.addAttribute("books",books);
        return "main";
    }



}
