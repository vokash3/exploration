package ru.wain.exploration.DTO;

import lombok.Data;

@Data
// Для приёма RequestBody в форме JSON
public class BookRequest {
    private String author;
    private String title;
    private Double price;
}
