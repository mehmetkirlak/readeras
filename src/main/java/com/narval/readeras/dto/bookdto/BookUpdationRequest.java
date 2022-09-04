package com.narval.readeras.dto.bookdto;

import com.narval.readeras.model.Category;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookUpdationRequest {

    @NotNull(message = "Author must not be null")
    private String author;

    @NotNull(message = "Title must not be null")
    private String title;

    @NotNull(message = "Page must not be null")
    private Short page;

    @NotNull(message = "Image must not be null")
    private String image;

    @NotNull(message = "Description must not be null")
    private String description;

    @NotNull
    @Min(0)
    private BigDecimal price;

    private int categoryId;
}

