package com.example.bookStoreServer.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {
            Book b1 = new Book (
                    "Silence of the Lambs",
                    "Thomas Harris",
                    2010,
                    34.99

            );

            Book b2 = new Book (
                    "The Red Dragon",
                    "Thomas Harris",
                    2011,
                    27.99

            );

            //now we have 2 books, and we want to save them into
            //our database
            repository.saveAll(
                    List.of(b1, b2)
            );
        };
    }
}
