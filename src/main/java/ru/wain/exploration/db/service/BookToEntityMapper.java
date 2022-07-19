package ru.wain.exploration.db.service;

import org.mapstruct.Mapper;
import ru.wain.exploration.db.entities.BookEntity;
import ru.wain.exploration.models.Book;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
    BookEntity bookToBookEntity(Book book);
    Book bookEntityToBook(BookEntity bookEntity);
}
