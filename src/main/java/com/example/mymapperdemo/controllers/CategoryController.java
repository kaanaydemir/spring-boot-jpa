package com.example.mymapperdemo.controllers;

import com.example.mymapperdemo.dtos.CategoryDto;
import com.example.mymapperdemo.entities.Category;
import com.example.mymapperdemo.mapper.CategoryMapperImpl;
import com.example.mymapperdemo.repositories.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1")
public class CategoryController {


    private final CategoryRepository categoryRepository;
    private final CategoryMapperImpl categoryMapperImpl;

    public CategoryController(CategoryRepository categoryRepository, CategoryMapperImpl categoryMapperImpl) {
        this.categoryRepository = categoryRepository;
        this.categoryMapperImpl = categoryMapperImpl;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Long id) {

        Category category = categoryRepository.findById (id)
                .orElseThrow (EntityNotFoundException::new);

        return ResponseEntity.ok (categoryMapperImpl.categoryToCategoryDto (category));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<Category> categories = categoryRepository.findAll ();
        List<CategoryDto> categoryDtos = categories.stream ()
                .map (categoryMapperImpl::categoryToCategoryDto)
                .collect (Collectors.toList ());
        return ResponseEntity.ok (categoryDtos);
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @NonNull @Valid CategoryDto categoryDto) {
        Category category = categoryMapperImpl.categoryDtoToCategory (categoryDto);
        return ResponseEntity.ok (categoryMapperImpl.categoryToCategoryDto (categoryRepository.save (category)));
    }

}



























