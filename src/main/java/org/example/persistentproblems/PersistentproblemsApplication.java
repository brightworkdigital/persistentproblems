package org.example.persistentproblems;

import org.example.persistentproblems.entities.Author;
import org.example.persistentproblems.entities.Book;
import org.example.persistentproblems.repos.AuthorRepo;
import org.example.persistentproblems.repos.BookRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class PersistentproblemsApplication {

    public static void main(String[] args) {

        ApplicationContext context =  SpringApplication.run(PersistentproblemsApplication.class, args);

        AuthorRepo authorRepo = context.getBean(AuthorRepo.class);
        BookRepo bookRepo = context.getBean(BookRepo.class);

        Author author = new Author("Tolstoy");
        author = authorRepo.save(author);
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
}
