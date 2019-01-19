package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Document(collection="bookSections")
@Entity
@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class BookSection {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(columnDefinition="CLOB")
    private String description;
    @OneToMany(targetEntity = BookContent.class,cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    @DBRef(db = "bookContents")
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
