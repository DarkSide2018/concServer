package com.concurrent.repository;

import com.concurrent.model.BookSection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookSectionRepository  extends JpaRepository<BookSection,Long> {

    @Override
    Optional<BookSection> findById(Long aLong);
}
