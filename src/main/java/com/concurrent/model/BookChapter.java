package com.concurrent.model;

import com.concurrent.config.CascadeSave;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "bookChapters")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookChapter extends BaseEn {


    private String bookId;

    @DBRef(db = "bookSections")
    @CascadeSave
    private Collection<BookSection> sectionList;

    public BookChapter(String title) {
        setTitle(title);
    }

    public BookChapter addBookSection(BookSection section) {
        if (sectionList == null) sectionList = new ArrayList<>();
        section.setChapterId(getUid());
        sectionList.add(section);
        return this;
    }
}

