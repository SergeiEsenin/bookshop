package com.example.bookshop.repo;

import com.example.bookshop.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BooksRepo extends JpaRepository<Book, Long> {


      Book findBookById(Long id);
}
