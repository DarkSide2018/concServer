package com.concurrent.transferObjects;

import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
@EqualsAndHashCode(callSuper = true)
@Data
public class BCeditTO extends BookContent {

    private List<BookSection> sectionTitles;

    public BCeditTO(BookContent content, List<BookSection> sectionTitles) {
        super(
                content.getId(),
                content.getTitle(),
                content.getUid(),
                content.getSectionId(),
                content.getContent());
        this.sectionTitles = sectionTitles;
    }

}
