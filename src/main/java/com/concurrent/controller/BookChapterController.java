package com.concurrent.controller;

import com.concurrent.repository.BookChapterMongoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookChapterController {
    @Autowired
    private BookChapterMongoRep contentRepository;

}
