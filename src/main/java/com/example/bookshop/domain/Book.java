package com.example.bookshop.domain;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;


    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "book_genre", joinColumns = @JoinColumn(name = "books_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "book_authors", joinColumns = @JoinColumn(name = "books_id"))
    private Set<String> authors;



    private String authorsStringed;

    private  String filename;

    private String finalpass;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    private double price;

    public Book() {

    }

    public Book(String name, Set<Genre> genres, Set<String> authors, double price,String filename) {
        this.name = name;
        this.genres = genres;
        this.filename=filename;
        this.price = price;
    }

    public String getAuthorsStringed() {
        return authorsStringed;
    }

    public void setAuthorsStringed(String authorsStringed) {
        this.authorsStringed = authorsStringed;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors=authors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Set<Genre> genres) {
        this.genres = genres;
    }

    public String getFinalpass() {
        return finalpass;
    }

    public void setFinalpass(String finalpass) {
        this.finalpass = finalpass;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
