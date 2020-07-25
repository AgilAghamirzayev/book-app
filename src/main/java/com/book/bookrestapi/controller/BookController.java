package com.book.bookrestapi.controller;

import com.book.bookrestapi.entity.Book;
import com.book.bookrestapi.exception.BookNotFoundException;
import com.book.bookrestapi.service.ServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.print.attribute.standard.MediaTray;
import java.util.Collection;

@Controller
@AllArgsConstructor
public class BookController {

    private final ServiceImp serviceImp;

    @GetMapping
    public ResponseEntity<Collection<Book>> findAll() {
        return new ResponseEntity<>(serviceImp.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        final Book book = serviceImp.findById(id).orElseThrow(() -> new BookNotFoundException("Book not found"));
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> save(Book book) {
        return new ResponseEntity<>(serviceImp.save(book),HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return new ResponseEntity<>(serviceImp.update(book), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        serviceImp.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
