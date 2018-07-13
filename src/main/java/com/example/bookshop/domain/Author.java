package com.example.bookshop.domain;

import com.sun.javafx.beans.IDProperty;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;

@Entity
@Table(name="authors")
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;

}
