package com.concurrent.repository;

import com.concurrent.model.BookContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookContentRepository extends JpaRepository<BookContent,Long> {

}
