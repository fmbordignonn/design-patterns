package com.teste.design.patterns.api;

import com.teste.design.patterns.model.request.BookRequest;
import com.teste.design.patterns.model.response.BookResponse;
import org.springframework.http.ResponseEntity;

@SuppressWarnings("unused")
public interface LibraryAPI {
    ResponseEntity<BookResponse> create(BookRequest bookEntity);

    ResponseEntity<BookResponse> get(Long id);
}
