package com.concurrent.config;

import com.concurrent.model.Book;
import com.concurrent.model.BookChapter;
import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookRepository;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class InitBean {
    @Autowired
    private BookRepository bookRepository;


    @PostConstruct
    public void fillTestData(){
        BookSection bookSection12 = new BookSection("Преимущества потоков");
        bookSection12.setDescription(computeDescription("txt/1.2_threadAdvantages"));
        BookContent bookContent121 = new BookContent("Использование нескольких процессоров");

        BookContent bookContent122 = new BookContent("Упрощение моделирования");
        BookContent bookContent123 = new BookContent("Упрощённая обработка асинхронных событий");
        BookContent bookContent124 = new BookContent("Более отзывчивый пользовательский интерфейс");
        bookSection12.addBookContent(bookContent121)
                .addBookContent(bookContent122)
                .addBookContent(bookContent123)
                .addBookContent(bookContent124);
        BookSection bookSection11 = new BookSection("Очень краткая история параллелизма");
        bookSection11.setDescription(computeDescription("txt/1.1_shortStory"));
        Book book = new Book("Ru Concurrency in practice");
        BookChapter bookChapter1 = new BookChapter("Введение");
        book.addChapter(bookChapter1);
        bookChapter1.addBookSection(bookSection11);
        bookChapter1.addBookSection(bookSection12);

        bookRepository.save(book);
    }

    private String computeDescription(String url){
        InputStream res12 = Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream(url);
        return IOUtils.toString(res12, Charset.defaultCharset());
    }
}
