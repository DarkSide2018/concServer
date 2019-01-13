package com.concurrent.repository;

import com.concurrent.model.BookSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;
@RepositoryRestResource
public interface BookSectionRepository  extends JpaRepository<BookSection,Long> {

    @Override
    Optional<BookSection> findById(Long aLong);
}
