package com.narval.readeras.services;


import com.narval.readeras.dto.bookdto.BookCreationRequest;
import com.narval.readeras.dto.bookdto.BookDTO;
import com.narval.readeras.dto.bookdto.BookDTOConverter;
import com.narval.readeras.dto.bookdto.BookUpdationRequest;
import com.narval.readeras.exception.CategoryNotFoundException;
import com.narval.readeras.model.Book;
import com.narval.readeras.model.Category;
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

    private final CategoryService categoryService;

    public BookService(BookRepository bookRepository, BookDTOConverter bookDTOConverter, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.bookDTOConverter = bookDTOConverter;
        this.categoryService = categoryService;
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
        Category category  = categoryService.getCategoryById(bookCreationRequest.getCategoryId());

        if (category == null ){
            throw new CategoryNotFoundException("Category Not Found");
        }

        Book book = Book.builder()
                .id(bookCreationRequest.getId())
                .page(bookCreationRequest.getPage())
                .image(bookCreationRequest.getImage())
                .author(bookCreationRequest.getAuthor())
                .price(bookCreationRequest.getPrice())
                .title(bookCreationRequest.getTitle())
                .description(bookCreationRequest.getDescription())
                .categoryId(bookCreationRequest.getCategoryId())
                .build();

        return bookDTOConverter.convert(bookRepository.save(book));
    }

    public BookDTO updateBook(int id, BookUpdationRequest bookUpdationRequest){
        Category category  = categoryService.getCategoryById(bookUpdationRequest.getCategoryId());

        if (category == null ){
            throw new CategoryNotFoundException("Category Not Found");
        }

        Optional<Book> bookOptional = bookRepository.findById(id);

        bookOptional.ifPresent(book -> {
                book.setPage(bookUpdationRequest.getPage());
                book.setImage(bookUpdationRequest.getImage());
                book.setAuthor(bookUpdationRequest.getAuthor());
                book.setPrice(bookUpdationRequest.getPrice());
                book.setTitle(bookUpdationRequest.getTitle());
                book.setDescription(bookUpdationRequest.getDescription());
                book.setCategoryId(bookUpdationRequest.getCategoryId());

                bookRepository.save(book);
                });
        return bookOptional.map(bookDTOConverter::convert).orElse(new BookDTO());
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

}
