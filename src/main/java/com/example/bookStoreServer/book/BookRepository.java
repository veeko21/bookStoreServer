package com.example.bookStoreServer.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//this interface is responsible data access layer
//we want to use this repository inside our service
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    //SELECT * FROM book WHERE title = ?
    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    Optional<Book> findBookByTitle(String title);
}
