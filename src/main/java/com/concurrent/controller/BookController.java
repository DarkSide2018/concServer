package com.concurrent.controller;

import com.concurrent.model.Book;
import com.concurrent.model.BookChapter;
import com.concurrent.repository.BookChapterMongoRep;
import com.concurrent.repository.BookMongoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookController {
    private BookMongoRep bookRepository;
    private BookChapterMongoRep chapterRepoitory;

    @Autowired
    public BookController(BookMongoRep bookRepository,
                          BookChapterMongoRep chapterRepoitory) {
        this.bookRepository = bookRepository;
        this.chapterRepoitory = chapterRepoitory;
    }

    @GetMapping("/book")
    //soon need return Collection
    public Book getBook() {

        return bookRepository.findAll().get(0);
    }

    @GetMapping("/bookChapter")
    // should return  Collection,  cannot return List
    public Collection<BookChapter> getChapters() {
        return chapterRepoitory.findAll();
    }


}
