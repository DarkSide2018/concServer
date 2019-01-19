package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @OneToMany(targetEntity = BookSection.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @DBRef(db = "bookSections")
    private List<BookSection> sectionList;

    public BookChapter(String title) {
        this.title = title;
    }

    public BookChapter addBookSection(BookSection section) {
        if (sectionList == null) sectionList = new ArrayList<>();
        sectionList.add(section);
        return this;
    }
}
