package com.teste.design.patterns.api;

import com.teste.design.patterns.model.Book;
import com.teste.design.patterns.service.BookService;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@Slf4j
public class LibraryAPIImpl implements LibraryAPI {

    private final BookService bookService;

    public LibraryAPIImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Book bookEntity) {
        log.info("Received a new create request...");

        bookService.create(bookEntity);

        log.info("Finished processing create request!");
    }

    @Override
    @GetMapping("/get")
    public ResponseEntity<Book> get(@RequestParam Long id) {
        log.info("Received a new create request...");

        ResponseEntity<Book> response = bookService.get(id);

        log.info("Finished processing create request!");

        return response;
    }
}
