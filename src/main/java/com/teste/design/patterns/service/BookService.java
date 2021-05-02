package com.teste.design.patterns.service;

import com.teste.design.patterns.model.request.BookRequest;
import com.teste.design.patterns.model.response.BookResponse;
import org.springframework.http.ResponseEntity;

public interface BookService {
    ResponseEntity<BookResponse> create(BookRequest request);

    ResponseEntity<BookResponse> get(Long id);
}
