package com.narval.readeras.services;

import com.narval.readeras.dto.categorydto.CategoryCreationRequest;
import com.narval.readeras.dto.categorydto.CategoryDTO;
import com.narval.readeras.dto.categorydto.CategoryDTOConverter;
import com.narval.readeras.dto.categorydto.CategoryUpdationRequest;
import com.narval.readeras.model.Category;
import com.narval.readeras.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDTOConverter categoryDTOConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryDTOConverter categoryDTOConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryDTOConverter = categoryDTOConverter;
    }

    public List<CategoryDTO> getAllCategories(){
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOList = new ArrayList<>();

        for (Category category:categoryList){
            categoryDTOList.add(categoryDTOConverter.convert(category));
        }
        return categoryDTOList;
    }

    public CategoryDTO getCategoryDTOById(int id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        return categoryOptional.map(categoryDTOConverter::convert).orElse(new CategoryDTO());
    }


    public CategoryDTO createCategory(CategoryCreationRequest categoryCreationRequest){
        Category category = new Category();
        category.setId(categoryCreationRequest.getId());
        category.setName(categoryCreationRequest.getName());

        categoryRepository.save(category);

        return categoryDTOConverter.convert(category);
    }

    public CategoryDTO updateCategory(int id, CategoryUpdationRequest categoryUpdationRequest){
        Optional<Category> categoryOptional = categoryRepository.findById(id);

        categoryOptional.ifPresent(category -> {
            category.setName(categoryUpdationRequest.getName());

            categoryRepository.save(category);
        });
        return categoryOptional.map(categoryDTOConverter::convert).orElse(new CategoryDTO());
    }

    public void deleteCategory(int id){
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(int id){
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Category category = categoryOptional.get();
        return category;
    }
}
