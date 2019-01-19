package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@Document(collection="bookContents")
@Entity
@Data
@NoArgsConstructor
@Embeddable
@AllArgsConstructor
public class BookContent {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    @Column(columnDefinition="CLOB")
    private String content;

    public BookContent(String title) {
        this.title = title;
    }
}
