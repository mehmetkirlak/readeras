package com.narval.readeras.dto.bookdto;

import com.narval.readeras.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    private int id;
    private String author;
    private String title;
    private Short page;
    private String description;
    private BigDecimal price;
    private Category category;
}
