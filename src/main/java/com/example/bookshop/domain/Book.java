package com.example.bookshop.domain;


import javax.persistence.*;
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


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="authors_id")
    private Author authors;

    public Book() {
    }

    public Book(String name, Set<Genre> genres, Author authors, double price) {
        this.name = name;
        this.genres = genres;
        this.authors = authors;
        this.price = price;
    }

    private double price;

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

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
