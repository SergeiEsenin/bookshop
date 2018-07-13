package com.example.bookshop.repo;

import com.example.bookshop.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author,Long> {
List<Author> findAll();

}
