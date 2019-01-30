package com.concurrent.model;

import com.concurrent.config.CascadeSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "bookSections")
@Entity
@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class BookSection extends BaseEn {

    private String chapterId;

    @Column(columnDefinition = "CLOB")
    private String description;
    @OneToMany(targetEntity = BookContent.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @DBRef(db = "bookContents")
    @CascadeSave
    private Collection<BookContent> bookContentList;

    public BookSection(String title) {
       setTitle(title);
    }

    public BookSection addBookContent(BookContent bookContent) {
        if (bookContentList == null) bookContentList = new ArrayList<>();
        bookContent.setSectionId(getUid());
        bookContentList.add(bookContent);
        return this;
    }

}
