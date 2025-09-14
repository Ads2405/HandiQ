package com.handiQ.productcatalog.controller;

import com.handiQ.productcatalog.model.Category;
import com.handiQ.productcatalog.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping()
    public List<Category> getAllCategories(){

        return categoryService.getAllCategories();
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody Category category){
         return categoryService.addCategory(category);
    }

}
