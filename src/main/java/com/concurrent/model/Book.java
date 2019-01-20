package com.concurrent.model;

import com.concurrent.config.CascadeSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
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

    @DBRef(db = "bookChapters")
    @CascadeSave
    private Collection<BookChapter> chapterList;

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
