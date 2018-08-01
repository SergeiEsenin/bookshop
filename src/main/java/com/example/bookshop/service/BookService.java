package com.example.bookshop.service;


import com.example.bookshop.domain.Book;
import com.example.bookshop.domain.Genre;
import com.example.bookshop.repo.BooksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookService {
    @Autowired
    private BooksRepo booksRepo;
    @Value("${upload.path}")
    private String uploadPath;




    public List<Book> findAll() {
        return booksRepo.findAll();
    }

    public void addBook(String title, Double price, Set<String> genres, String authors, MultipartFile file, String annot) {
        Book book = new Book();
        book.setName(title);

        if (validateBook(book)) {
            prepForSave(book, price, genres, authors,annot,file);


            saveBook(book);
        }

    }

    public void editBook(Long id, String title, Double price, Set<String> genres, String authors,String annot, MultipartFile file) {

        booksRepo.deleteById(id);
        Book book = new Book();
        book.setName(title);

        prepForSave(book, price, genres, authors,annot,file);
        saveBook(book);


    }

    private void prepForSave(Book book, Double price, Set<String> genres, String authors,String annot,MultipartFile file) {

            book.setAnnotation(annot);

        book.setPrice(price);
        book.setGenres(validateGenres(genres));
        book.setAuthorsStringed(authors);
        Set<String> authorSet = parser(authors);
        book.setAuthors(authorSet);
        setAndSafePic(file,book);
    }
    private void setAndSafePic(MultipartFile file,Book book){
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadFolder = new File(uploadPath);
            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + file.getOriginalFilename();
            try {
                file.transferTo(new File(uploadPath + "/" + resultFileName));
            } catch (IOException e) {
                e.printStackTrace();
            }

            book.setFilename(resultFileName);
            book.setFinalpass(uploadPath + "/" + resultFileName);
        }
    }



    private Set<Genre> validateGenres(Set<String> genres) {
        Set<Genre> set = new HashSet<>();
        for (String genre : genres) {
            Genre g = Genre.valueOf(genre);
            set.add(g);
        }

        return set;
    }

    private boolean validateBook(Book book) {
        List<Book> books = booksRepo.findAll();
        return !books.contains(book);
    }

    public List<Book> filtredBooks(String filter){
        List<Book> books=booksRepo.findAll();
        Set<Book> sortedByBookName=books.stream().filter(e->e.getName().toLowerCase().equals(filter.toLowerCase())).collect(Collectors.toSet());
        Set<Book> sortedByAuthor = new HashSet<>();
        for (Book e : books) {
            if (e.getAuthors().stream().anyMatch(p -> p.toLowerCase().equals(filter.toLowerCase()))) {
                sortedByAuthor.add(e);
            }
        }
        sortedByBookName.addAll(sortedByAuthor);
        if (filter != null && !filter.isEmpty()) {


            return new ArrayList<Book>(sortedByBookName);

        } else {
            return books;
        }
    }



    private static Set<String> parser(String line) {
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



    private void saveBook(Book book) {
        booksRepo.save(book);
    }

    public Book findBookById(Long id) {


        return booksRepo.findBookById(id);
    }


    public void delete(Long id) {
        booksRepo.deleteById(id);
    }
}
