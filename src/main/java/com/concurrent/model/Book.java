package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
