package com.example.bookshop.service;

import com.example.bookshop.domain.Author;
import com.example.bookshop.domain.Book;
import com.example.bookshop.domain.Genre;
import com.example.bookshop.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BooksRepo booksRepo;

    @Autowired
    private AuthorService authorService;

    public List<Book> findAll() {
        return booksRepo.findAll();
    }

    public void addBook(String title, Double price, Set<String> genres, String authors) {
        Book book = new Book();
        book.setName(title);
        if (validateBook(book)){
        book.setPrice(price);
        book.setGenres(validateGenres(genres));
        Set<Author> authorSet = authorService.validate(generateSetOfAuthors(parser(authors)), book);
        authorSet.forEach(book::setAuthors);

            saveBook(book);}

    }
public void editBook(Long id,String title, Double price, Set<String> genres, String authors) {
Book book = findBookById(id);
    book.setName(title);
    book.setPrice(price);
    book.setGenres(validateGenres(genres));
    Set<Author> authorSet = authorService.validate(generateSetOfAuthors(parser(authors)), book);
    authorSet.forEach(book::setAuthors);

    if (validateBook(book))
        saveBook(book);



}


    private Set<Genre> validateGenres(Set<String> genres) {
        Set<Genre> set = new HashSet<>();
        for (String genre : genres) {
            Genre g = Genre.valueOf(genre);
            set.add(g);
        }

        return set;
    }

    public boolean validateBook(Book book) {
        List<Book> books = booksRepo.findAll();
        return !books.contains(book);
    }


    public static Set<String> parser(String line) {
        Set<String> set = new HashSet<>();
        char[] c = line.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (c[i] != ' ') {
                if (c[i] == ',') {
                    set.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                } else {
                    if (stringBuilder.length() == 0) {
                        stringBuilder.append(Character.toUpperCase(c[i]));

                    } else if (i + 1 == c.length) {
                        stringBuilder.append(c[i]);
                        set.add(stringBuilder.toString());
                    } else
                        stringBuilder.append(c[i])
                                ;
                }
            } else if (stringBuilder.length() > 0 && i + 1 == c.length) {
                set.add(stringBuilder.toString());
            }

        }
        return set;
    }

    private Set<Author> generateSetOfAuthors(Set<String> set) {


        return set.stream().map(Author::new).collect(Collectors.toSet());
    }

    private void saveBook(Book book) {
        booksRepo.save(book);
    }

    public Book findBookById(Long id) {



    return   booksRepo.findBookById(id);
}


    public void delete(Long id) {
        booksRepo.deleteById(id);
    }
}
