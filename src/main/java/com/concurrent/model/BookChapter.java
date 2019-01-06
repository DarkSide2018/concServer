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
public class BookChapter {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @OneToMany(targetEntity = BookSection.class, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
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
