package com.handiQ.productcatalog.controller;

import com.handiQ.productcatalog.model.Product;
import com.handiQ.productcatalog.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/category/{categoryId}")
    public  List<Product> getAllProductsByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }
    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @DeleteMapping("deleteProduct/{id}")
    public  void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

    @PutMapping("updateProduct/{id}")
    public void updateProduct(@PathVariable("id")Long id ,@RequestBody Product product){
        productService.updateProduct(id,product);
    }
}
