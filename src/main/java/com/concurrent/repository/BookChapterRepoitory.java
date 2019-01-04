package com.concurrent.repository;

import com.concurrent.model.BookChapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookChapterRepoitory extends JpaRepository<BookChapter,Long> {

}
