package org.example.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;
    private String name;
    private String country;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    List<Book> books;

    public Author(){}

    public Author(int authorId, String name, String country, List<Book> books) {
        this.authorId = authorId;
        this.name = name;
        this.country = country;
        this.books = books;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", books=" + books +
                '}';
    }
}
