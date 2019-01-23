package com.concurrent.controller;

import com.concurrent.model.BookSection;
import com.concurrent.repository.BookSectionMongoRep;
import com.concurrent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookSectionController {

    private final BookService bookService;

    private final BookSectionMongoRep sectionRepository;

    @Autowired
    public BookSectionController(BookService bookService, BookSectionMongoRep sectionRepository) {
        this.bookService = bookService;
        this.sectionRepository = sectionRepository;
    }

    @GetMapping("/bookSection")
    public Collection<BookSection> getSections() {
        return sectionRepository.findAll();
    }

    @PostMapping("/bookSection")
    public BookSection saveSection(BookSection section) {
        sectionRepository.save(section);
        return section;
    }

    @PutMapping("/bookSection")
    public BookSection updateSection(BookSection section) {
        sectionRepository.save(section);
        return section;
    }

    @DeleteMapping("/bookSection")
    public void deleteSection(Long id) {
        sectionRepository.deleteById(id);
    }

    @GetMapping("/bookSectionById")
    public BookSection getSectionById(@RequestParam Long id) {
        return bookService.getSectionById(id);
    }
}
