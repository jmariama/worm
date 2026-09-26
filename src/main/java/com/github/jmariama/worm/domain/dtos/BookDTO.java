package com.github.jmariama.worm.domain.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//controls fields public fields for api
public class BookDTO {

    @Null
    private UUID id;

    @NotBlank(message = "Please provide a valid title for Book")
    private String title;

    @NotBlank(message = "Please provide a valid author for Book")
    private String author;

    private String genre;

    private String coverUrl;

    private float rating;

    private String summary;

    @NotNull(message = "Please provide a valid published year!")
    @Min(value = 0, message = "Published year has to be greater than 0!")
    @Max(value = 2026, message = "Published year cannot take place in the future!")
    private int published_year;

    @NotNull(message = "Minimum copies cannot be null!")
    @Min(value = 0, message = "Minimum available copies cannot be less than zero!")
    private Integer total_copies;

    @Null
    private Integer available_copies;

}