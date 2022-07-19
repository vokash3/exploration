package ru.wain.exploration.db.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.wain.exploration.db.entities.BookEntity;
import ru.wain.exploration.db.repo.BookRepository;
import ru.wain.exploration.models.Book;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService{
    private final BookRepository bookRepository;
    private final BookToEntityMapper mapper;

    @SneakyThrows
    @Override
    public Book getBookById(Long id) {
        BookEntity bookEntity = bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found: id = " + id));
//        return new Book(bookEntity.getId(), bookEntity.getAuthor(), bookEntity.getTitle(), bookEntity.getPrice());
        return mapper.bookEntityToBook(bookEntity);
    }

    @Override
    public List<Book> getAllBooks() {
        Iterable<BookEntity> iterable = bookRepository.findAll();
        List<Book> books = new ArrayList<>();
        for(BookEntity bookEntity : iterable)
//            books.add(new Book(bookEntity.getId(), bookEntity.getAuthor(), bookEntity.getTitle(), bookEntity.getPrice()));
            books.add(mapper.bookEntityToBook(bookEntity));
        return books;
    }

    @Override
    public void addBook(Book book) {
//        BookEntity bookEntity = new BookEntity(null, book.getAuthor(), book.getTitle(), book.getPrice());
        BookEntity bookEntity = mapper.bookToBookEntity(book);
        bookRepository.save(bookEntity);
    }

    private class BookNotFoundException extends Exception{
        public BookNotFoundException(String message) {
            super(message);
        }
    }
}
