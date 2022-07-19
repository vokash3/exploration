package ru.wain.exploration.DTO;

import org.mapstruct.Mapper;
import ru.wain.exploration.models.Book;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
    Book addBookRequestToBook(BookRequest bookRequest);
}
