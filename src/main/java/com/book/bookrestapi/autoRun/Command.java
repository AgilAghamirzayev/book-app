package com.book.bookrestapi.autoRun;

import com.book.bookrestapi.entity.Book;
import com.book.bookrestapi.service.ServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class Command implements CommandLineRunner {

    private final ServiceImp serviceImp;

    @Override
    public void run(String... args) throws Exception {
        Book book = new Book();
        book.setTitle("Spring Microservices in Action");
        book.setAuthor("John Carnell");
        book.setCoverPhotoUrl("https://images-na.ssl-images-amazon.com/images/I/417zLTa1uqL._SX397_BO1,204,203,200_" +
                ".jpg");
        book.setIsbnNumber(1617293989L);
        book.setPrice(2776.00);
        book.setLanguage("English");
        serviceImp.save(book);
    }
}
