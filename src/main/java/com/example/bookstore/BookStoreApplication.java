package com.example.bookstore;

import com.example.bookstore.model.Book;
import com.example.bookstore.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BookStoreApplication {

    private final BookService bookService;

    public BookStoreApplication(BookService bookService) {
        this.bookService = bookService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                Book book = Book.builder()
                        .title("Colony")
                        .author("Max Kidruk")
                        .price(BigDecimal.valueOf(500))
                        .description("Will add later...probably")
                        .coverImage("imgUrl")
                        .isbn("978-617-95267-2-5")
                        .build();

                bookService.save(book);

                System.out.println(bookService.findAll());
            }
        };
    }

}
