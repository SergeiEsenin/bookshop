package com.example.bookshop.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="authors")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name="books_id")
    private Set<Book> books = new HashSet<>();

    public Author(String name) {
        this.name = name;

    }

    public Author() {
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

    public Set<Book> getBook() {
        return books;
    }

    public void setBook(Book book) {
        books.add(book);
    }
    public void setBook(Set<Book> book) {
        books=book;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return
                Objects.equals(name, author.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name);
    }
}
