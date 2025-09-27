package com.handiQ.productcatalog.service;


import com.handiQ.productcatalog.model.Category;
import com.handiQ.productcatalog.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.Response;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

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


    public void deleteCategory(Long id) {

        Optional<Category> op = categoryRepository.findById(id);

        if (op.isPresent()) {
            Category category = op.get();


            if (category.getProducts() != null && !category.getProducts().isEmpty()) {
                System.out.println("Invalid Request: Products exist in the category.");
            } else {
                categoryRepository.deleteById(id);
                System.out.println("Category deleted successfully.");
            }
        } else {
            // If the category is not found, print an error message
            System.out.println("Category not found with ID: " + id);
        }
    }

    public void updateCategory(Long id,String name){
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Category not found."));

        category.setName(name);

        categoryRepository.saveAndFlush(category);
    }
}
