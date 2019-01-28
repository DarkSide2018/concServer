package com.concurrent.transferObjects;

import com.concurrent.model.BookContent;
import lombok.Data;

import java.util.List;
@Data
public class BCeditTO extends BookContent {

    private List<String> sectionTitles;

    public BCeditTO(BookContent content, List<String> sectionTitles) {
        super(
                content.getId(),
                content.getTitle(),
                content.getUid(),
                content.getSectionId(),
                content.getContent());
        this.sectionTitles = sectionTitles;
    }

}
