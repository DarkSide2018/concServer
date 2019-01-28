package com.concurrent.service;

import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookContentMongoRep;
import com.concurrent.repository.BookSectionMongoRep;
import com.concurrent.transferObjects.BCeditTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class BookService {

    public static final BookSection EMPTY_SECTION = new BookSection("empty");
    public static final BookContent EMPTY_CONTENT = new BookContent("empty");
    private final BookSectionMongoRep sectionRepository;
    private final BookContentMongoRep contentMongoRep;

    @Autowired
    public BookService(BookSectionMongoRep sectionRepository, BookContentMongoRep contentMongoRep) {
        this.sectionRepository = sectionRepository;
        this.contentMongoRep = contentMongoRep;
    }

    public Collection<BookContent> getContentBySection(Long id) {
        BookSection bookSection = sectionRepository.findById(id).orElse(EMPTY_SECTION);
        return contentMongoRep.findBookContentBySectionId(bookSection.getUid());
    }


    public BookSection getSectionById(Long id) {
        return sectionRepository
                .findById(id)
                .orElse(EMPTY_SECTION);
    }

    public BCeditTO getContentById(Long id){
        BookContent bookContent = contentMongoRep.findById(id).orElse(EMPTY_CONTENT);
        return new BCeditTO(bookContent,new ArrayList<>());
    }

}
