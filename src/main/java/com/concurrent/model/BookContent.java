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

    private String title;

    private String sectionId;

    @Column(columnDefinition = "CLOB")
    private String content;

    public BookContent(String title) {
        this.title = title;
    }

}
