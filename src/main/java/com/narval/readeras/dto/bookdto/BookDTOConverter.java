package com.narval.readeras.dto.bookdto;

import com.narval.readeras.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookDTOConverter {
    public BookDTO convert(Book book){
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setPage(book.getPage());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setCategoryId(book.getCategoryId());
        return bookDTO;
    }
}
