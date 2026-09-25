package com.github.jmariama.worm.controller;


import com.github.jmariama.worm.domain.dtos.BookDTO;
import com.github.jmariama.worm.services.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//for manipulating book data
@RestController
@RequestMapping(path = "/library/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping()
    public ResponseEntity<BookDTO> createBook(@RequestBody @Valid BookDTO book) {
        BookDTO savedBook = bookService.createBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Page<BookDTO>> getAllBooks(){
        Page<BookDTO> allBooks = (Page<BookDTO>) bookService.getAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<List<BookDTO>> getAllAvailableBooks(){
        List<BookDTO> availableBooks = bookService.getAllAvailableBooks();
        return new ResponseEntity<>(availableBooks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable String id){
        Optional<BookDTO> retrievedBookOptional = bookService.getBookById(id);

        return retrievedBookOptional.map(bookDto -> new ResponseEntity<>(bookDto, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping(path = "author/{authorName}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable("authorName") String authorName){
        List<BookDTO> booksByAuthor = bookService.getBooksByAuthor(authorName);
        return new ResponseEntity<>(booksByAuthor, HttpStatus.OK);
    }
}
