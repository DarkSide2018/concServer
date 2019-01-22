package com.concurrent.controller;

import com.concurrent.model.BookContent;
import com.concurrent.repository.BookContentMongoRep;
import com.concurrent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookContentController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookContentMongoRep contentRepository;

    @GetMapping("/bookContentBySectionId")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BookContent> getContentBySection(@RequestParam Long id) {
        return bookService.getContentBySection(id);
    }

    @GetMapping("/bookContent")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BookContent> getContents() {
        return contentRepository.findAll();
    }

    @GetMapping("/bookContentById")
    @CrossOrigin(origins = "http://localhost:4200")
    public BookContent getContentById(@RequestParam Long id) {
        return contentRepository.findById(id).orElse(new BookContent());
    }
}
