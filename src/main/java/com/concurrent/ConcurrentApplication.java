package com.concurrent;

import com.concurrent.model.*;
import com.concurrent.repository.BookRepository;
import com.concurrent.repository.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ConcurrentApplication {

    public static void main(String[] args) {

        SpringApplication.run(ConcurrentApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository carRepository, BookRepository bookRepository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Porsche", "Lamborghini", "Bugatti",
                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV").forEach(name -> {
                Car car = new Car();
                car.setName(name);
                carRepository.save(car);
            });
            BookSection bookSection12 = new BookSection("Преимущества потоков");
            BookContent bookContent121 = new BookContent("Использование нескольких процессоров");
            BookContent bookContent122 = new BookContent("Упрощение моделирования");
            BookContent bookContent123 = new BookContent("Упрощённая обработка асинхронных событий");
            BookContent bookContent124 = new BookContent("Более отзывчивый пользовательский интерфейс");
            bookSection12.addBookContent(bookContent121)
                    .addBookContent(bookContent122)
                    .addBookContent(bookContent123)
                    .addBookContent(bookContent124);
            BookSection bookSection11 = new BookSection("Очень краткая история параллелизма");
            Book book = new Book("Ru Concurrency in practice");
            BookChapter bookChapter1 = new BookChapter("Введение");
            book.addChapter(bookChapter1);
            bookChapter1.addBookSection(bookSection11);
            bookChapter1.addBookSection(bookSection12);

            bookRepository.save(book);
        };
    }
}

