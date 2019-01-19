package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Document(collection="books")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @OneToMany(targetEntity = BookChapter.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @DBRef(db = "bookChapters")
    private List<BookChapter> chapterList;

    public Book(String title) {
        this.title = title;
    }

    public void addChapter(BookChapter chapter) {
        if (chapterList == null) {
            chapterList = new ArrayList<>();
        }
        chapterList.add(chapter);
    }
}
