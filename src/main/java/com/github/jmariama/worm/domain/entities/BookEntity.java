package com.github.jmariama.worm.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name ="books")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;

    private String author;

    private String genre;

    private float rating;

    @Column(columnDefinition = "TEXT")
    private String summary;

    private String coverUrl;

    private int published_year;

    private int total_copies;

    private int available_copies;


    //checks for duplicates
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BookEntity that = (BookEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) && Objects.equals(author, that.author)
                && Objects.equals(genre, that.genre)
                && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, genre, rating);
    }
}