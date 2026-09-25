package com.github.jmariama.worm.services;

import com.github.jmariama.worm.domain.dtos.BookDTO;
import com.github.jmariama.worm.domain.entities.BookEntity;
import com.github.jmariama.worm.exception.InsufficientBookFieldsException;
import com.github.jmariama.worm.mappers.Mapper;
import com.github.jmariama.worm.repositories.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final Mapper<BookEntity, BookDTO> bookMapper;

    @Override
    public BookDTO createBook(BookDTO bookDto) {
        if (bookDto.getTitle() == null || bookDto.getAuthor() == null)
            throw new InsufficientBookFieldsException("Insufficient Data for Book Entity");

        BookEntity savedBook = bookRepository.save(bookMapper.mapFrom(bookDto));
        return bookMapper.mapTo(savedBook);
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookEntity> allBooks = bookRepository.findAll();
        return allBooks
                .stream()
                .map(bookMapper::mapTo)
                .toList();
    }

    @Override
    public Optional<BookDTO> getBookById(String id) {
        Optional<BookEntity> bookOptional = bookRepository.getBookById(UUID.fromString(id));
        return bookOptional.map(bookMapper::mapTo);
    }

    @Override
    public List<BookDTO> getAllAvailableBooks() {
        List<BookEntity> availableBooks = bookRepository.findAvailableBooks();

        return availableBooks
                .stream()
                .map(bookMapper::mapTo)
                .toList();
    }

    @Override
    public Page<BookDTO> getAllBooks(Pageable pageable) {
        return null;
    }

    @Override
    public List<BookDTO> getBooksByAuthor(String authorName) {
        List<BookEntity> booksByAuthor = bookRepository.getBooksByAuthor(authorName);

        return booksByAuthor
                .stream()
                .map(bookMapper::mapTo)
                .toList();
    }

    @Override
    public List<BookDTO> getBooksPublishedInYear(int publishedYear) {
        List<BookEntity> booksPublishedInYear = bookRepository.getBooksPublishedInYear(publishedYear);

        return booksPublishedInYear
                .stream()
                .map(bookMapper::mapTo)
                .toList();
    }

}