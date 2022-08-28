package com.narval.readeras.dto;

import com.narval.readeras.model.Category;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreationRequest {
    private int id;
    private String author;
    private String title;
    private Short page;
    private String image;
    private String description;
    private BigDecimal price;
    private Category category;
}
