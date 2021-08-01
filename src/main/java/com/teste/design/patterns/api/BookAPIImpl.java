package com.teste.design.patterns.api;

import com.teste.design.patterns.model.request.BookRequest;
import com.teste.design.patterns.model.response.BookResponse;
import com.teste.design.patterns.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/book")
@Slf4j
public class BookAPIImpl implements BookAPI {

    private final BookService bookService;

    public BookAPIImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<BookResponse> create(@RequestBody BookRequest bookRequest) {
        log.info("Received a new create request...");

        ResponseEntity<BookResponse> response = bookService.create(bookRequest);

        log.info("Finished processing create request!");

        return response;
    }

    @Override
    @GetMapping("/get/{id}")
    public ResponseEntity<BookResponse> get(@PathVariable Long id) {
        log.info("Received a new create request...");

        ResponseEntity<BookResponse> response = bookService.get(id);

        log.info("Finished get request!");

        return response;
    }
}
