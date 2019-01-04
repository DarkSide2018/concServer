package com.concurrent.repository;

import com.concurrent.model.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookContentRepository extends JpaRepository<BookContent,Long> {
}
