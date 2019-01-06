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
public class BookSection {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(columnDefinition="CLOB")
    private String description;
    @OneToMany(targetEntity = BookContent.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BookContent> bookContentList;

    public BookSection(String title) {
        this.title = title;
    }

    public BookSection addBookContent(BookContent bookContent) {
        if (bookContentList == null) bookContentList = new ArrayList<>();
        bookContentList.add(bookContent);
        return this;
    }
}
