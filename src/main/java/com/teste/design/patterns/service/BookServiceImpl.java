package com.teste.design.patterns.service;

import com.teste.design.patterns.model.entity.BookEntity;
import com.teste.design.patterns.model.request.BookRequest;
import com.teste.design.patterns.model.response.BookResponse;
import com.teste.design.patterns.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public ResponseEntity<BookResponse> create(BookRequest request) {
        BookEntity entity = new BookEntity(request.getName(), request.getDescription());

        log.info("Saving entity to database....");

        bookRepository.save(entity);

        log.info("Entity successfully saved, generated id is [{}]", entity.getId());

        return ResponseEntity.ok(
                BookResponse.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .description(entity.getDescription())
                        .build());
    }

    @Override
    public ResponseEntity<BookResponse> get(Long id) {
        //sdds webflux
        return bookRepository.findById(id)
                .map(optional -> {
                    log.info("Book found, building response");
                    return ResponseEntity.ok(
                            BookResponse.builder()
                                    .id(optional.getId())
                                    .name(optional.getName())
                                    .description(optional.getDescription())
                                    .build());
                })
                .orElseGet(() -> {
                    log.info("Book not found! building empty response");
                    return ResponseEntity.ok(BookResponse.builder().build());
                });
    }
}
