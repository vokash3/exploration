package ru.wain.exploration.db.service;

import ru.wain.exploration.models.Book;

import java.util.List;

public interface BookService {

    Book getBookById(Long id);// получить книгу по id
    List<Book> getAllBooks();// получить список всех книг
    void addBook(Book book);// добавить книгу
    List<Book> findByAuthor(String author);
}
