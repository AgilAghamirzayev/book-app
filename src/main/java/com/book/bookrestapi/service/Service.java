package com.book.bookrestapi.service;

import com.book.bookrestapi.entity.Book;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Service {

    Collection<Book> findAll();
    Optional<Book> findById(Long id);
    Book saveOrUpdate(Book book);
    Book save(Book book);
    Book update(Book book);
    void deleteById(Long id);
    List<Book> saveAll(List<Book> bookList);

}
