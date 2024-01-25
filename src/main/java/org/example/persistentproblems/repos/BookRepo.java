package org.example.persistentproblems.repos;

import org.example.persistentproblems.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
}
