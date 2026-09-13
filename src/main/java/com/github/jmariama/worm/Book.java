package com.github.jmariama.worm;

import jakarta.persistence.Entity;

@Entity
public class Book {
    private int id;
    private String title;
    private String author;
    private int status;
    private double rating;
    private String notes;
    private String dateStarted;
    private String dateFinished;



}
