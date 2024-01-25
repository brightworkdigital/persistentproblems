package org.example.persistentproblems.repos;

import org.aspectj.lang.annotation.Before;
import org.example.persistentproblems.entities.Author;
import org.example.persistentproblems.entities.Book;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class AuthorRepoTest {

    @Autowired
    AuthorRepo authorRepo;
    @Autowired
    BookRepo bookRepo;

    @BeforeAll
    void beforeAll() {

        Author author = new Author("Tolstoy");
        authorRepo.save(author);
        Book book = new Book(author, "War and Peace");
        bookRepo.save(book);
        book = new Book(author, "Anna Karenina");
        bookRepo.save(book);

        author = new Author("Melville");
        authorRepo.save(author);
        book = new Book(author, "Moby-Dick");
        bookRepo.save(book);

        author = new Author("Dave");
        authorRepo.save(author);
    }

    @Test
    void getBooksByAuthorOne() {
        List<Book> books = authorRepo.getBooksByAuthor("Melville");
        assertEquals(1,books.size());
    }

    @Test
    void getBooksByAuthorTwo() {
        List<Book> books = authorRepo.getBooksByAuthor("Tolstoy");
        assertEquals(2,books.size());
    }

    @Test
    void getBooksByNonexistantAuthor() {
        List<Book> books = authorRepo.getBooksByAuthor("Stewart");
        assertEquals(0,books.size());
    }

    @Test
    void testGetAllAuthors() {

        List<Author> authors = authorRepo.getAllAuthors();
        assertEquals(2, authors.size());
    }

    @Test
    void testGetAuthorsWithNoBooks() {
        List<Author> authors = authorRepo.getAuthorsWithNoBooks();

        System.out.println("debug");
    }
}