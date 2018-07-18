package com.example.bookshop;

import com.example.bookshop.domain.Author;
import com.example.bookshop.domain.Book;
import com.example.bookshop.repo.BooksRepo;
import com.example.bookshop.service.AuthorService;
import com.example.bookshop.service.BookService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookshopApplicationTests {
@Autowired
    BooksRepo booksRepo;
@Autowired
BookService bookService;





    @Test
    public void authorTest(){

        List<Book> list = new ArrayList<>();
       Book b = new Book();
       b.setName("Hello World");
        Book b1 = new Book();
      //  b.setName("Hello1");
        list.add(b); list.add(b1);

        System.out.println(bookService.findAll().get(0).getName());
        System.out.println(b.getName());
                Assert.assertEquals(true,bookService.validateBook(b));

    }

}
