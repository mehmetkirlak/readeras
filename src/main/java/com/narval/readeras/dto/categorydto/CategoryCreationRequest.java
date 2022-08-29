package com.narval.readeras.dto.categorydto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryCreationRequest {
    private int id;
    private String name;
}
