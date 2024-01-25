package org.example.persistentproblems.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NamedQuery(name = "Author.getBooksByAuthor", query = "select b from Book b join b.author a where a.name = :authorName")
//@NamedQuery(name = "Author.BooksByAuthor", query = "select b.title, a.name from Book b join b.author a where a.name = :name")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Book> books = new HashSet<>();


    public Author(String name) {
        this.name = name;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {this.id = id;}

    public Long getId() {return id;}
    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
