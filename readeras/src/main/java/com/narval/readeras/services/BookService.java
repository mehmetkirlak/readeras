package com.narval.readeras.services;


import com.narval.readeras.model.Book;
import com.narval.readeras.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public Book getBookById(int id){
    Optional<Book> bookOptional = bookRepository.findById(id);
    Book book = bookOptional.get();
    return book;
    }

    public Book createBook

}
