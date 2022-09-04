package com.narval.readeras.dto.bookdto;

import com.narval.readeras.model.Category;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookCreationRequest {

    private int id;

    @NotEmpty(message = "Author must not be null")
    private String author;

    @NotEmpty(message = "Title must not be null")
    private String title;

    @NotNull(message = "Page must not be null")
    private Short page;

    @NotEmpty(message = "Image must not be null")
    private String image;

    @NotEmpty(message = "Description must not be null")
    private String description;

    @NotNull
    @Min(0)
    private BigDecimal price;

    @NotNull(message = "Category id must not be null")
    private int categoryId;
}
