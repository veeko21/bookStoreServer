package com.example.bookStoreServer.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {

    /**
     * @Autowired injects bookservice into BookController constructor
     */
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //we want to get something u=out of our server
    @GetMapping
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @PostMapping
    public void registerNewBook(@RequestBody Book book) {
        bookService.addNewBook(book);
    }
    
    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(
            @PathVariable("bookId") Long bookId,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) Integer year,
            @RequestParam(required = false) Double price) {
        bookService.updateBook(bookId, title, author, year, price);
    }
}
