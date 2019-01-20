package com.concurrent.controller;

import com.concurrent.model.Book;
import com.concurrent.model.BookChapter;
import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookChapterMongoRep;
import com.concurrent.repository.BookContentMongoRep;
import com.concurrent.repository.BookMongoRep;
import com.concurrent.repository.BookSectionMongoRep;
import com.concurrent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BookController {
    private BookMongoRep bookRepository;
    private BookChapterMongoRep chapterRepoitory;
    private BookContentMongoRep contentRepository;
    private BookSectionMongoRep sectionRepository;
    private BookService bookService;

    @Autowired
    public BookController(BookMongoRep bookRepository,
                          BookChapterMongoRep chapterRepoitory,
                          BookContentMongoRep contentRepository,
                          BookSectionMongoRep sectionRepository,
                          BookService bookService) {
        this.bookRepository = bookRepository;
        this.chapterRepoitory = chapterRepoitory;
        this.contentRepository = contentRepository;
        this.sectionRepository = sectionRepository;
        this.bookService = bookService;
    }

    @GetMapping("/book")
    @CrossOrigin(origins = "http://localhost:4200")
    //soon need return Collection
    public Book getBook() {

        return bookRepository.findAll().get(0);
    }

    @GetMapping("/bookChapter")
    @CrossOrigin(origins = "http://localhost:4200")
    // should return  Collection,  cannot return List
    public Collection<BookChapter> getChapters() {
        return chapterRepoitory.findAll();
    }

    @GetMapping("/bookSection")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BookSection> getSections() {
        return sectionRepository.findAll();
    }

    @PostMapping("/bookSection")
    @CrossOrigin(origins = "http://localhost:4200")
    public BookSection saveSection(BookSection section) {
        sectionRepository.save(section);
        return section;
    }

    @PutMapping("/bookSection")
    @CrossOrigin(origins = "http://localhost:4200")
    public BookSection updateSection(BookSection section) {
        sectionRepository.save(section);
        return section;
    }

    @DeleteMapping("/bookSection")
    @CrossOrigin(origins = "http://localhost:4200")
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    @GetMapping("/bookContentBySectionId")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<BookContent> getContentBySection(@RequestParam Long id) {
        return bookService.getContentBySection(id);
    }

    @GetMapping("/bookSectionById")
    @CrossOrigin(origins = "http://localhost:4200")
    public BookSection getSectionById(@RequestParam Long id) {
        return bookService.getSectionById(id);
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
