package com.concurrent.service;

import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    public static final BookSection EMPTY_SECTION = new BookSection("empty");
    @Autowired
    private BookSectionRepository sectionRepository;

    public List<BookContent> getContentBySection(Long id) {

        return sectionRepository
                .findById(id)
                .orElse(EMPTY_SECTION)
                .getBookContentList();
    }


    public BookSection getSectionById(Long id){
        return sectionRepository
                .findById(id)
                .orElse(EMPTY_SECTION);
    }

}
