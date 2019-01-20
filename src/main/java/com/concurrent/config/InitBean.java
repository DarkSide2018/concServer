package com.concurrent.config;

import com.concurrent.model.Book;
import com.concurrent.model.BookChapter;
import com.concurrent.model.BookContent;
import com.concurrent.model.BookSection;
import com.concurrent.repository.BookContentMongoRep;
import com.concurrent.repository.BookMongoRep;
import com.concurrent.repository.BookSectionMongoRep;
import io.micrometer.core.instrument.util.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.InputStream;
import java.nio.charset.Charset;

@Component
public class InitBean {
    @Autowired
    private BookMongoRep bookRepository;
    @Autowired
    private BookSectionMongoRep sectionMongoRep;
    @Autowired
    private BookContentMongoRep contentMongoRep;
    @PostConstruct
    public void fillTestData() {
        bookRepository.deleteAll();
        sectionMongoRep.deleteAll();
        contentMongoRep.deleteAll();
        BookSection bookSection12 = new BookSection("1.2 Преимущества потоков");
        bookSection12.setDescription(computeDescription("txt/1.2_threadAdvantages"));
        BookContent bookContent121 = new BookContent("1.2.1 Использование нескольких процессоров");
        bookContent121.setContent(computeDescription("txt/1.2.1_useMultipleCores"));
        BookContent bookContent122 = new BookContent("1.2.2 Упрощение моделирования");
        bookContent122.setContent(computeDescription("txt/1.2.2_simpleModelling"));
        BookContent bookContent123 = new BookContent("1.2.3 Упрощённая обработка асинхронных событий");
        bookContent123.setContent(computeDescription("txt/1.2.3_simpleAsyncEvents"));
        BookContent bookContent124 = new BookContent("1.2.4 Более отзывчивый пользовательский интерфейс");
        bookContent124.setContent(computeDescription("txt/1.2.4_userFriendlyInterface"));
        bookSection12
                .addBookContent(bookContent121)
                .addBookContent(bookContent122)
                .addBookContent(bookContent123)
                .addBookContent(bookContent124);
        BookSection bookSection11 = new BookSection("1.1 Очень краткая история параллелизма");
        bookSection11.setDescription(computeDescription("txt/1.1_shortStory"));
        Book book = new Book("Ru Concurrency in practice");
        BookChapter bookChapter1 = new BookChapter("Введение");
        book.addChapter(bookChapter1);

        BookSection bookSection13 = new BookSection("1.3 Риски, которые несут потоки");
        bookSection13.setDescription(computeDescription("txt/1.3_threadRisks"));
        BookContent bookContent131 = new BookContent("1.3.1 Угрозы безопасности");
        bookContent131.setContent(computeDescription("txt/1.3.1_dangerSecurity"));
        BookContent bookContent132 = new BookContent("1.3.2 Угрозы живучести потока");
        bookContent132.setContent(computeDescription("txt/1.3.2_dangerThreadLife"));
        BookContent bookContent133 = new BookContent("1.3.3 Угрозы производительности");
        bookContent133.setContent(computeDescription("txt/1.3.3_dangerPerfomance"));
        bookSection13
                .addBookContent(bookContent131)
                .addBookContent(bookContent132)
                .addBookContent(bookContent133);
        bookChapter1
                .addBookSection(bookSection11)
                .addBookSection(bookSection12)
                .addBookSection(bookSection13);
        bookRepository.save(book);
    }

    private String computeDescription(String url) {
        InputStream res12 = Thread
                .currentThread()
                .getContextClassLoader()
                .getResourceAsStream(url);
        return IOUtils.toString(res12, Charset.defaultCharset());
    }
}
