package com.example.bookshop.service;

import com.example.bookshop.domain.Book;
import com.example.bookshop.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{
@Autowired
    private BooksRepo booksRepo;

public List<Book> findAll(){
    return booksRepo.findAll();
}

}
