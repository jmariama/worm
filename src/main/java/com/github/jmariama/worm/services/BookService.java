package com.github.jmariama.worm.services;

import com.github.jmariama.worm.domain.dtos.BookDTO;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface BookService {
    BookDTO createBook(BookDTO bookDto);
    List<BookDTO> getAllAvailableBooks();
    Page<BookDTO> getAllBooks(Pageable pageable);

    List<BookDTO> getAllBooks();

    Optional<BookDTO> getBookById(String id);
    List<BookDTO> getBooksByAuthor(String authorName);
    List<BookDTO> getBooksPublishedInYear(int publishedYear);
}

