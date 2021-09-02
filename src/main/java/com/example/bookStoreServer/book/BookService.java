package com.example.bookStoreServer.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks() {

        return bookRepository.findAll();
    }

    public void addNewBook(Book book) {
        Optional<Book> bookOptional = bookRepository.findBookByTitle(book.getTitle());

        //if book is present, throw an exception
        if (bookOptional.isPresent()) {
            throw new IllegalStateException("Email taken.");
        }
        //if book is not present, save it
        bookRepository.save(book);

    }

    public void deleteBook(Long bookId) {
        boolean exists = bookRepository.existsById(bookId);
        if(!exists) {
            throw new IllegalStateException("student with id " + bookId + " does not exist");
        }
        bookRepository.deleteById(bookId);
    }

    @Transactional
    public void updateBook(Long bookId, String title, String author, int year, double price) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalStateException(
                "book with id " + bookId + " does not exist"));

        if(title != null && title.length() > 0 && !Objects.equals(book.getTitle(), title)) {
            book.setTitle(title);
        }

        if(author != null && author.length() > 0 && !Objects.equals(book.getAuthor(), author)) {
            book.setAuthor(author);
        }
    }
}
