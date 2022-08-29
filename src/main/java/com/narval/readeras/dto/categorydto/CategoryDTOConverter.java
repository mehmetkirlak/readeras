package com.narval.readeras.dto.categorydto;

import com.narval.readeras.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDTOConverter {

    public CategoryDTO convert(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }
}
