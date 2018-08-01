package com.example.bookshop.controller;

import com.example.bookshop.domain.Book;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;
import java.util.stream.Collectors;

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
        return "some";
    }

    @GetMapping("/shop")
    public String main(@RequestParam(name = "filterino",required = false, defaultValue = "") String filter ,
                       Model model) {

model.addAttribute("books",bookService.filtredBooks(filter));
        return "main";
    }

    @GetMapping("/shop/{book}")
    public String about(@PathVariable Book book,Model model){

        model.addAttribute("book",book);
        return "details";

    }







    @GetMapping("/shop/priceUp")
    public String filterPriceUp(@RequestParam(name = "filterino",required = false, defaultValue = "") String filter ,Model model) {

        List<Book> books = bookService.filtredBooks(filter);
books.sort(Comparator.comparing(Book::getPrice));



        model.addAttribute("books",books);
        return "main";
    }
    @GetMapping("/shop/priceDown")
    public String filterPriceDown(@RequestParam(name = "filterino",required = false, defaultValue = "") String filter ,Model model) {

        List<Book> books = bookService.filtredBooks(filter);
        books.sort(Comparator.comparing(e -> e.getPrice() * -1));


        model.addAttribute("books",books);
        return "main";
    }



}
