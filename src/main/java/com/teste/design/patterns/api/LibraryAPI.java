package com.teste.design.patterns.api;

import com.teste.design.patterns.model.Book;
import org.springframework.http.ResponseEntity;

public interface LibraryAPI {
    void create(Book bookEntity);

    ResponseEntity<Book> get(Long id);
}
