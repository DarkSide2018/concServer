package com.concurrent.controller;

import com.concurrent.model.BookSection;
import com.concurrent.repository.BookSectionMongoRep;
import com.concurrent.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BookSectionController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookSectionMongoRep sectionRepository;

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

    @GetMapping("/bookSectionById")
    @CrossOrigin(origins = "http://localhost:4200")
    public BookSection getSectionById(@RequestParam Long id) {
        return bookService.getSectionById(id);
    }
}
