package com.concurrent.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookContent {
    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String content;

    public BookContent(String title) {
        this.title = title;
    }
}
