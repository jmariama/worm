package com.github.jmariama.worm.mappers;

import com.github.jmariama.worm.domain.dtos.BookDTO;
import com.github.jmariama.worm.domain.entities.BookEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookMapper implements Mapper<BookEntity, BookDTO> {

        private final ModelMapper modelMapper;

        @Override
        public BookDTO mapTo(BookEntity bookEntity) {
            return modelMapper.map(bookEntity, BookDTO.class);
        }

        @Override
        public BookEntity mapFrom(BookDTO bookDto) {
            return modelMapper.map(bookDto, BookEntity.class);
        }
    }

