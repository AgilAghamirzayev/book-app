package com.book.bookrestapi.controller;

import com.book.bookrestapi.entity.Book;
import com.book.bookrestapi.exception.BookNotFoundException;
import com.book.bookrestapi.service.ServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")

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

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book) {
        System.out.println(book);
        return new ResponseEntity<>(serviceImp.save(book),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Book> update(@RequestBody Book book) {
        return new ResponseEntity<>(serviceImp.update(book), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        System.out.println(id);
        serviceImp.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/all")
    public ResponseEntity<List<Book>> saveAll(@RequestBody List<Book> bookList) {
        bookList.forEach(System.out::println);
        return new ResponseEntity<>(serviceImp.saveAll(bookList), HttpStatus.OK);
    }
}
