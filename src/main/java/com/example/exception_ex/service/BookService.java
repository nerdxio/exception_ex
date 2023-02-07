package com.example.exception_ex.service;

import com.example.exception_ex.exception.BookNotFoundException;
import com.example.exception_ex.model.Book;
import com.example.exception_ex.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BookNotFoundException("this entity id = " + id + " Not found"));
    }

    public Book insert(Book book) {
        return repository.save(book);
    }
}
