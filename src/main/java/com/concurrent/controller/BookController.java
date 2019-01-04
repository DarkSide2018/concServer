package com.concurrent.controller;

import com.concurrent.model.Book;
import com.concurrent.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    private BookRepository bookRepository;
    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping("/book")
    @CrossOrigin(origins = "http://localhost:4200")
    public Book getBook(){
        return bookRepository.findAll().get(0);
    }
}
