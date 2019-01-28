package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Document(collection = "bookContents")
@Entity
@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class BookContent extends BaseEn {

    private String sectionId;

    public BookContent(long id, String title, String uid, String sectionId, String content) {
        super(id, title, uid);
        this.sectionId = sectionId;
        this.content = content;
    }

    @Column(columnDefinition = "CLOB")
    private String content;

    public BookContent(String title) {
       setTitle(title);
    }

}
