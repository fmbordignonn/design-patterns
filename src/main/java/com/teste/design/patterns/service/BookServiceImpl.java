package com.teste.design.patterns.service;

import com.teste.design.patterns.model.Book;
import com.teste.design.patterns.repository.BookRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void create(Book bookEntity) {
        bookRepository.save(bookEntity);
    }

    @Override
    public ResponseEntity<Book> get(Long id) {
        Optional<Book> book = bookRepository.findById(id);

        return book.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.ok(new Book()));

    }
}
