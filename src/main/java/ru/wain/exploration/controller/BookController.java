package ru.wain.exploration.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.wain.exploration.DTO.BookRequest;
import ru.wain.exploration.DTO.BookToDtoMapper;
import ru.wain.exploration.db.service.BookService;
import ru.wain.exploration.models.Book;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;
    private final BookToDtoMapper mapper;

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<Book> getAllBooks(@RequestParam(required = false) String author) {
        if(author != null)
            return bookService.findByAuthor(author);
        return bookService.getAllBooks();
    }

    @PostMapping
    public void addBook(@RequestBody BookRequest request) {
        bookService.addBook(mapper.addBookRequestToBook(request));
    }
}
