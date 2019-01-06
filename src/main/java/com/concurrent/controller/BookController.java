package com.concurrent.controller;

import com.concurrent.model.Book;
import com.concurrent.model.BookChapter;
import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookChapterRepoitory;
import com.concurrent.repository.BookContentRepository;
import com.concurrent.repository.BookRepository;
import com.concurrent.repository.BookSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BookController {
    private BookRepository bookRepository;
    private BookChapterRepoitory chapterRepoitory;
    private BookContentRepository contentRepository;
    private BookSectionRepository sectionRepository;

    @Autowired
    public BookController(BookRepository bookRepository,
                          BookChapterRepoitory chapterRepoitory,
                          BookContentRepository contentRepository,
                          BookSectionRepository sectionRepository) {
        this.bookRepository = bookRepository;
        this.chapterRepoitory = chapterRepoitory;
        this.contentRepository = contentRepository;
        this.sectionRepository = sectionRepository;
    }

    @GetMapping("/book")
    @CrossOrigin(origins = "http://localhost:4200")
    //Скоро нужно будет возвращать Collection
    public Book getBook() {

        return bookRepository.findAll().get(0);
    }

    @GetMapping("/bookChapter")
    @CrossOrigin(origins = "http://localhost:4200")
    // почему то нужно возращать именно Collection List вернуть не получилось
    public Collection<BookChapter> getChapters() {
        return chapterRepoitory.findAll();
    }

    @GetMapping("/bookSection")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BookSection> getSections() {
        return sectionRepository.findAll();
    }

    @GetMapping("/bookContent")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BookContent> getContents() {
        return contentRepository.findAll();
    }

}
