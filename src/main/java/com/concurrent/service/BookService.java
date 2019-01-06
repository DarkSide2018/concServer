package com.concurrent.service;

import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookSectionRepository sectionRepository;

    public List<BookContent> getSectionById(Long id) {
        return sectionRepository
                .findById(id)
                .orElse(new BookSection("empty"))
                .getBookContentList();
    }

}
