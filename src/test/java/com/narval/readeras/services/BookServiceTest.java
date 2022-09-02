package com.narval.readeras.services;

import com.narval.readeras.dto.bookdto.BookCreationRequest;
import com.narval.readeras.dto.bookdto.BookDTO;
import com.narval.readeras.dto.bookdto.BookDTOConverter;
import com.narval.readeras.dto.bookdto.BookUpdationRequest;
import com.narval.readeras.dto.categorydto.CategoryDTOConverter;
import com.narval.readeras.model.Book;
import com.narval.readeras.model.Category;
import com.narval.readeras.repository.BookRepository;
import com.narval.readeras.repository.CategoryRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.math.BigDecimal;


class BookServiceTest {

    private BookService service;

    private BookRepository bookRepository;
    private  BookService bookService;
    private BookDTOConverter bookDTOConverter;
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private CategoryDTOConverter categoryDTOConverter;


    @BeforeEach
    void setUp() {
        bookRepository = Mockito.mock(BookRepository.class);
        bookService = Mockito.mock(BookService.class);
        bookDTOConverter = Mockito.mock(BookDTOConverter.class);

        categoryRepository = Mockito.mock(CategoryRepository.class);
        categoryService = Mockito.mock(CategoryService.class);
        categoryDTOConverter = Mockito.mock(CategoryDTOConverter.class);

        service = new BookService(bookRepository,bookDTOConverter, categoryService);
    }

    @Test
    public void whenCreateBookCalledWithValidRequest_itShouldReturnValidBookDto(){
        BookCreationRequest bookCreationRequest = generateBookCreationRequest();
        Book book = generateBook(bookCreationRequest);
        Category category = generateCategory();
        BookDTO bookDTO = generateBookDto();

        Mockito.when(categoryService.getCategoryById(123)).thenReturn(category);
        Mockito.when(bookRepository.save(book)).thenReturn(book);
        Mockito.when(bookDTOConverter.convert(book)).thenReturn(bookDTO);

        BookDTO result = service.createBook(bookCreationRequest);

        Assert.assertEquals(result,bookDTO);
        Mockito.verify(bookRepository).save(book);
        Mockito.verify(bookDTOConverter).convert(book);
    }

    private BookCreationRequest generateBookCreationRequest(){

        BookCreationRequest bookCreationRequest = new BookCreationRequest();
        bookCreationRequest.setId(123);
        bookCreationRequest.setAuthor("test-author");
        bookCreationRequest.setTitle("test-title");
        bookCreationRequest.setDescription("test-description");
        bookCreationRequest.setPage((short) 1234);
        bookCreationRequest.setPrice(BigDecimal.valueOf(12));
        bookCreationRequest.setImage("test-image");
        bookCreationRequest.setCategory(generateCategory());
        return bookCreationRequest;
    }

    private BookUpdationRequest generateBookUpdationRequest(){

        BookUpdationRequest bookUpdationRequest = new BookUpdationRequest();
        bookUpdationRequest.setAuthor("test-author");
        bookUpdationRequest.setTitle("test-title");
        bookUpdationRequest.setDescription("test-description");
        bookUpdationRequest.setPage((short) 12);
        bookUpdationRequest.setPrice(BigDecimal.valueOf(12));
        bookUpdationRequest.setImage("test-image");
        bookUpdationRequest.setCategory(generateCategory());
        return bookUpdationRequest;
    }

    private Category generateCategory(){
        return Category.builder()
                .id(123)
                .name("test-category")
                .build();
    }

    private Book generateBook(BookCreationRequest bookCreationRequest) {
        return Book.builder()
                .id(bookCreationRequest.getId())
                .author(bookCreationRequest.getAuthor())
                .title(bookCreationRequest.getTitle())
                .description(bookCreationRequest.getDescription())
                .page(bookCreationRequest.getPage())
                .image(bookCreationRequest.getImage())
                .price(bookCreationRequest.getPrice())
                .category(bookCreationRequest.getCategory())
                .build();
    }

    private BookDTO generateBookDto(){
        return BookDTO.builder()
                .id(123)
                .author("test-author")
                .title("test-title")
                .description("test-description")
                .page((short) 123)
                .price(BigDecimal.valueOf(12))
                .category(generateCategory())
                .build();
    }
}