package com.concurrent.transferObjects;

import com.concurrent.model.BookSection;
import lombok.Data;

import java.util.List;

@Data
public class BSeditTO extends BookSection {
    private List<String> chapterTitles;
}
