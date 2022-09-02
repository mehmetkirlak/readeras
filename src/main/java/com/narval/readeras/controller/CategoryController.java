package com.narval.readeras.controller;

import com.narval.readeras.dto.categorydto.CategoryCreationRequest;
import com.narval.readeras.dto.categorydto.CategoryDTO;
import com.narval.readeras.dto.categorydto.CategoryUpdationRequest;
import com.narval.readeras.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    public CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories(){
        return ResponseEntity.ok(categoryService.getAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(int id){
        return ResponseEntity.ok(categoryService.getCategoryDTOById(id));
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryCreationRequest categoryCreationRequest){
        return ResponseEntity.ok(categoryService.createCategory(categoryCreationRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable int id, @RequestBody CategoryUpdationRequest categoryUpdationRequest){
        return ResponseEntity.ok(categoryService.updateCategory(id, categoryUpdationRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable int id){
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }

}
