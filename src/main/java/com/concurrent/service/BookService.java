package com.concurrent.service;

import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookContentMongoRep;
import com.concurrent.repository.BookSectionMongoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService {
    public static final BookSection EMPTY_SECTION = new BookSection("empty");
    @Autowired
    private BookSectionMongoRep sectionRepository;

    @Autowired
    private BookContentMongoRep contentMongoRep;


    public Collection<BookContent> getContentBySection(Long id) {

        BookSection bookSection = sectionRepository.findById(id).orElse(EMPTY_SECTION);
        return contentMongoRep.findBookContentBySectionId(bookSection.getUid());
    }


    public BookSection getSectionById(Long id) {
        return sectionRepository
                .findById(id)
                .orElse(EMPTY_SECTION);
    }

}
