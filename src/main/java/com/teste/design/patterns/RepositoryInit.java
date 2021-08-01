package com.teste.design.patterns;

import com.teste.design.patterns.model.entity.BookEntity;
import com.teste.design.patterns.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class RepositoryInit implements CommandLineRunner {
    private final BookRepository bookRepository;

    public RepositoryInit(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {
        BookEntity book1 = new BookEntity("O homem mais rico da babilônia", "Muito bom livro");
        BookEntity book2 = new BookEntity("Papo de grana", "Ensinou bastante");
        BookEntity book3 = new BookEntity("Livro 3", "livro (y)");

        var books = List.of(book1, book2, book3);

        bookRepository.saveAll(books);

        log.info("Books createad at project startup:");
        log.info(Arrays.toString(books.toArray()));
    }
}
