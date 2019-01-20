package com.concurrent.model;

import com.concurrent.config.CascadeSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;

@Document(collection="bookChapters")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookChapter {
    @Id
    @GeneratedValue
    private long id;

    private String title;
    @DBRef(db = "bookSections")
    @CascadeSave
    private Collection<BookSection> sectionList;

    public BookChapter(String title) {
        this.title = title;
    }

    public BookChapter addBookSection(BookSection section) {
        if (sectionList == null) sectionList = new ArrayList<>();
        sectionList.add(section);
        return this;
    }
}

