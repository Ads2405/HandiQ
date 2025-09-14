//package com.handiQ.productcatalog.config;
//
//import com.handiQ.productcatalog.model.Category;
//import com.handiQ.productcatalog.model.Product;
//import com.handiQ.productcatalog.repository.CategoryRepository;
//import com.handiQ.productcatalog.repository.ProductRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//
//@Component
//public class DataSeeder implements CommandLineRunner {
//
//    private final ProductRepository productRepository;
//    private  final CategoryRepository categoryRepository;
//
//    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
//        this.productRepository = productRepository;
//        this.categoryRepository = categoryRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        //remove all existing data;
//
//        productRepository.deleteAll();
//        categoryRepository.deleteAll();
//
//        //Categories Create
//        Category electronics = new Category();
//        electronics.setName("Electronics");
//        Category apparel = new Category();
//        apparel.setName("Apparel");
//        Category home = new Category();
//        home.setName("Home and Kitchen");
//
//        categoryRepository.saveAll(Arrays.asList(electronics,home,apparel));
//        System.out.print("categories added");
//        //Create Products
//
//        Product laptop = new Product();
//        laptop.setName("Laptop");
//        laptop.setDescription("Intel i5 RTX 1050");
//        laptop.setImageUrl("https://placehold.co/600x400");
//        laptop.setPrice(49999.99);
//        laptop.setCategory(electronics);
//
//        Product shirt = new Product();
//        shirt.setName("Men's Shirt");
//        shirt.setDescription("White Colored Casual Shirt");
//        shirt.setImageUrl("https://placehold.co/600x400");
//        shirt.setPrice(699.99);
//        shirt.setCategory(apparel) ;
//
//        Product bedsheet = new Product();
//        bedsheet.setName("Bedsheet");
//        bedsheet.setDescription("Floral 2x Bedsheet");
//        bedsheet.setImageUrl("https://placehold.co/600x400");
//        bedsheet.setPrice(999.99);
//        bedsheet.setCategory(home);
//        System.out.print("product added");
//        productRepository.saveAll(Arrays.asList(laptop,shirt,bedsheet));
//
//
//    }
//}