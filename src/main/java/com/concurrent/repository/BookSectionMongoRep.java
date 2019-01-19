package com.concurrent.repository;

import com.concurrent.model.BookSection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface BookSectionMongoRep extends MongoRepository<BookSection,Long> {
}
