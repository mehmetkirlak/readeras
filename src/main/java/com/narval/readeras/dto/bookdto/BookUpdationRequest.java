package com.narval.readeras.dto.bookdto;

import com.narval.readeras.model.Category;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdationRequest {
    private String author;
    private String title;
    private Short page;
    private String image;
    private String description;
    private BigDecimal price;
    private Category category;
}
