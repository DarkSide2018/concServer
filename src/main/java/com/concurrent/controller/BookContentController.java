package com.concurrent.controller;

import com.concurrent.model.BookContent;
import com.concurrent.repository.BookContentMongoRep;
import com.concurrent.service.BookService;
import com.concurrent.transferObjects.BCeditTO;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Log
@CrossOrigin(origins = "http://localhost:4200")
public class BookContentController {
    private final BookService bookService;
    private final BookContentMongoRep contentRepository;

    @Autowired
    public BookContentController(BookService bookService, BookContentMongoRep contentRepository) {
        this.bookService = bookService;
        this.contentRepository = contentRepository;
    }

    @GetMapping("/bookContentBySectionId")
    public Collection<BookContent> getContentBySection(@RequestParam Long id) {
        return bookService.getContentBySection(id);
    }

    @GetMapping("/bookContent")
    public Collection<BookContent> getContents() {
        return contentRepository.findAll();
    }

    @GetMapping("/bookContentById")
    public BookContent getContentById(@RequestParam Long id) {

        return bookService.getContentById(id);
    }

    @PostMapping(value = "/bookContent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public BookContent saveContent(@RequestBody BookContent bookContent) {
        contentRepository.save(bookContent);
        return bookContent;
    }

    @PutMapping("/bookContent")
    public BookContent updateContent(@RequestBody BookContent bookContent) {
        contentRepository.save(bookContent);
        return bookContent;
    }

    @DeleteMapping("/bookContent")
    public void deleteContent(BookContent bookContent) {
        contentRepository.delete(bookContent);
    }

}
