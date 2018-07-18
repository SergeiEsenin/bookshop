package com.example.bookshop.controller;

import com.example.bookshop.domain.Book;
import com.example.bookshop.domain.Genre;
import com.example.bookshop.service.AuthorService;
import com.example.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@Controller
public class BooksController {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/add")
    public String add(Model model) {

        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books",books);

        return "bookList";
    }

    @PostMapping("/add")
    public String addNew(@RequestParam String title, @RequestParam Double price, @RequestParam Set<String> genres,
                         @RequestParam String authors, Model model) {
        bookService.addBook(title,price,genres,authors);
        model.addAttribute("books",bookService.findAll());

        return "bookList";
    }
    @GetMapping("/add/{id}")
    public String addNew(@PathVariable Long id , Model model) {
        Book book = bookService.findBookById(id);
        model.addAttribute("book",book);
        model.addAttribute("genres", Genre.values());
        model.addAttribute("authors",book.getGenres());

        return "editBook";
    }



    @PostMapping("/add/{id}")
    public String addNew(@PathVariable Long id , @RequestParam String title, @RequestParam Double price, @RequestParam Set<String> genres,
                         @RequestParam String authors, Model model) {
        bookService.addBook(title,price,genres,authors);
        model.addAttribute("books",bookService.findAll());

        return "editBook";
    }
    @GetMapping("del/{id}")
    public String delete(@PathVariable Long id , Model model) {

        authorService.getAuthorByBookNameAndDelBook(bookService.findBookById(id));
        bookService.delete(id);
        Iterable<Book> books = bookService.findAll();
        model.addAttribute("books",books);

        return "redirect:/add";
    }



}
