package com.narval.readeras.services;


import com.narval.readeras.dto.BookCreationRequest;
import com.narval.readeras.dto.BookDTO;
import com.narval.readeras.dto.BookDTOConverter;
import com.narval.readeras.dto.BookUpdationRequest;
import com.narval.readeras.model.Book;
import com.narval.readeras.repository.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookDTOConverter bookDTOConverter;

    public BookService(BookRepository bookRepository, BookDTOConverter bookDTOConverter) {
        this.bookRepository = bookRepository;
        this.bookDTOConverter = bookDTOConverter;
    }

    public List<BookDTO> getAllBooks(){
        List<Book> bookList = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();

        for (Book book: bookList){
            bookDTOList.add(bookDTOConverter.convert(book));
        }

        return bookDTOList;
    }

    @Transactional
    public BookDTO getBookById(int id){
    Optional<Book> bookOptional = bookRepository.findById(id);
    return bookOptional.map(bookDTOConverter::convert).orElse(new BookDTO());
    }

    public BookDTO createBook(BookCreationRequest bookCreationRequest){
        Book book = new Book();
        book.setId(bookCreationRequest.getId());
        book.setPage(bookCreationRequest.getPage());
        book.setImage(bookCreationRequest.getImage());
        book.setAuthor(bookCreationRequest.getAuthor());
        book.setPrice(bookCreationRequest.getPrice());
        book.setTitle(bookCreationRequest.getTitle());
        book.setDescription(bookCreationRequest.getDescription());
        book.setCategory(bookCreationRequest.getCategory());

        bookRepository.save(book);

        return bookDTOConverter.convert(book);
    }

    public BookDTO updateBook(int id, BookUpdationRequest bookCreationRequest){
        Optional<Book> bookOptional = bookRepository.findById(id);

        bookOptional.ifPresent(book -> {
                book.setPage(bookCreationRequest.getPage());
                book.setImage(bookCreationRequest.getImage());
                book.setAuthor(bookCreationRequest.getAuthor());
                book.setPrice(bookCreationRequest.getPrice());
                book.setTitle(bookCreationRequest.getTitle());
                book.setDescription(bookCreationRequest.getDescription());
                book.setCategory(bookCreationRequest.getCategory());

                bookRepository.save(book);
                });
        return bookOptional.map(bookDTOConverter::convert).orElse(new BookDTO());
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

}
