package com.example.bookshop.domain;


import javax.persistence.*;
import java.util.HashSet;
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

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="authors_id")
    private Set<Author> authors=new HashSet<>();


    private double price;

    public Book() {
    }

    public Book(String name, Set<Genre> genres, Set<Author> authors, double price) {
        this.name = name;
        this.genres = genres;

        this.price = price;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Author author) {
        authors.add(author);
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
