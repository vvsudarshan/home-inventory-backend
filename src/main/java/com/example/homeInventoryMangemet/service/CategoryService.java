package com.example.homeInventoryMangemet.service;


import org.springframework.stereotype.Service;

import com.example.homeInventoryMangemet.model.Category;
import com.example.homeInventoryMangemet.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
