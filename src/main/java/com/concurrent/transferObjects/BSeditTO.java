package com.concurrent.transferObjects;

import com.concurrent.model.BookSection;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class BSeditTO extends BookSection {
    private List<String> chapterTitles;
}
