package com.teste.design.patterns.service;

import com.teste.design.patterns.model.Book;
import org.springframework.http.ResponseEntity;

public interface BookService {
    void create(Book request);

    ResponseEntity<Book> get(Long id);
}
