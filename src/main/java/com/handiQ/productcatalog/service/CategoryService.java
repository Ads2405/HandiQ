package com.handiQ.productcatalog.service;


import com.handiQ.productcatalog.model.Category;
import com.handiQ.productcatalog.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAllCategories() {
        return (List<Category>) categoryRepository.findAll();
    }

    public Category addCategory(Category category){
//        category.setName(category.getName());

        return categoryRepository.saveAndFlush(category);
    }
}
