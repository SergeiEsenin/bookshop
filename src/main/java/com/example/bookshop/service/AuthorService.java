package com.example.bookshop.service;

import com.example.bookshop.domain.Author;
import com.example.bookshop.domain.Book;
import com.example.bookshop.repo.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorRepo authorRepo;


    private void save(Author author) {
        authorRepo.save(author);
    }

    public Set<Author> validate(Set<Author> set, Book book) {
            Iterator<Author> it = set.iterator();
            Iterable<Author> iterable = authorRepo.findAll();
            for (; it.hasNext(); ) {
                Author author = it.next();
                if (!((List<Author>) iterable).contains(author)) {
                    save(author);
                } else {
                    if (!author.getBook().contains(book)) {
                        author.setBook(book);
                        save(author);
                    }
                }
            }
        return set;
    }


    public void getAuthorByBookNameAndDelBook(Book bookById) {
        Set<Author>  authors=bookById.getAuthors();

for(Author author: authors){
Author  authorEntity= authorRepo.findByName(author.getName());
Set<Book> set=authorEntity.getBook().stream().filter(e->!e.equals(bookById)).collect(Collectors.toSet());
authorEntity.setBook(set);

}

    }
}
