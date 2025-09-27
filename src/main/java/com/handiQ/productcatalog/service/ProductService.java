package com.handiQ.productcatalog.service;

import com.handiQ.productcatalog.model.Category;
import com.handiQ.productcatalog.model.Product;
import com.handiQ.productcatalog.repository.CategoryRepository;
import com.handiQ.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    private  CategoryRepository categoryRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId){
        return productRepository.findByCategoryId(categoryId );
    }

    public Product addProduct(Product product){
        if (product.getCategory() != null && product.getCategory().getName() != null) {
            // Check if the category already exists by name
            Category category = categoryRepository.findByName(product.getCategory().getName());
            if (category == null) {
                category = new Category();
                category.setName(product.getCategory().getName());
                categoryRepository.save(category);
            }
            product.setCategory(category);
        }
        // Save the Product
        return productRepository.saveAndFlush(product);
    }

    public void deleteProduct(Long id) {

        Optional<Product> op =productRepository.findById(id);

        if (op.isPresent()) {
//            Product product = op.get();
//
//
//            if (product.getId()==null) {
//                System.out.println("Invalid Request: Products doesnt exists.");
//            } else {
                productRepository.deleteById(id);
                System.out.println("Product deleted successfully.");
//            }
        } else {
            // If the category is not found, print an error message
            System.out.println("Product not found with ID: " + id);
        }
    }
}
