package com.narval.readeras.controller;

import com.narval.readeras.dto.bookdto.BookCreationRequest;
import com.narval.readeras.dto.bookdto.BookDTO;
import com.narval.readeras.dto.bookdto.BookUpdationRequest;
import com.narval.readeras.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    public BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable int id){
        return ResponseEntity.ok(bookService.getBookById(id)); //gets books by their id
    }

    @PostMapping
    public ResponseEntity<Object> createBook(@Valid @RequestBody BookCreationRequest bookCreationRequest){
        return ResponseEntity.ok(bookService.createBook(bookCreationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable int id, @RequestBody BookUpdationRequest bookUpdationRequest){
        return ResponseEntity.ok(bookService.updateBook(id,bookUpdationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    // TODO: getBookByCategoryName function

}
