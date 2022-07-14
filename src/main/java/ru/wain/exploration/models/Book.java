package ru.wain.exploration.models;

import lombok.Value;

@Value // add getters, конструктор, пометит все поля класса private final, добавит методы hashCode, equals и toString.
public class Book {
    Long id;
    String author;
    String title;
    Double price;
}
