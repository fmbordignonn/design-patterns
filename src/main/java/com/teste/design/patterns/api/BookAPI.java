package com.teste.design.patterns.api;

import com.teste.design.patterns.model.request.BookRequest;
import com.teste.design.patterns.model.response.BookResponse;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
public interface BookAPI {
    ResponseEntity<BookResponse> create(BookRequest bookEntity);

    ResponseEntity<BookResponse> get(Long id);
}
