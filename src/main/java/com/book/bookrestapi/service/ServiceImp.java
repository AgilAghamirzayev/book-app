package com.book.bookrestapi.service;

import com.book.bookrestapi.entity.Book;
import com.book.bookrestapi.exception.BookNotFoundException;
import com.book.bookrestapi.repository.BookRepository;
import lombok.AllArgsConstructor;

import java.util.Collection;
import java.util.Optional;

@org.springframework.stereotype.Service
@AllArgsConstructor
public class ServiceImp implements Service{

    private final BookRepository bookRepository;

    @Override
    public Collection<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return bookRepository.saveAndFlush(book);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book) {

        if (book.getId() == null)
            throw new BookNotFoundException("Book ID not found, ID is required for update the data");

        return bookRepository.saveAndFlush(book);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
