package org.example.persistentproblems.repos;

import org.example.persistentproblems.entities.Author;
import org.example.persistentproblems.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepo extends JpaRepository<Author, Long> {
    @Query(name = "Author.getBooksByAuthor")
    List<Book> getBooksByAuthor(String authorName);

    @Query("select a from Author a")
    List<Author> getAllAuthors();

    Author findAuthorByName(String name);

    @Query("select a from Author a where a.name = \"Dave\"")
    Author myGetAuthorByName(String name);

    @Query("select a from Book b right join b.author a group by a having count(b.title) = 0")
    List<Author> getAuthorsWithNoBooks();

    // update author by name?
}
