package com.github.jmariama.worm;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    private String title;
    @Getter
    private String author;



    private String genre;
    private int status;
    private double rating;
    private String notes;
    private String dateStarted;
    private String dateFinished;

public Book() {

}

public Book(Long id, String title, String author, String genre, String status ) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.genre = genre;

}

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDateStarted(String dateStarted) {
        this.dateStarted = dateStarted;
    }

    public void setDateFinished(String dateFinished) {
        this.dateFinished = dateFinished;
    }

}
