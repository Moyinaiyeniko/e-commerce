package com.products.service.controller;

import com.products.service.dto.ProductRequest;
import com.products.service.entity.Product;
import com.products.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductServiceImpl impl;

    @PostMapping(value = "/addproducts")
    public void addProducts(@RequestParam("file") MultipartFile image,
                            @RequestParam("name") String productName,
                            @RequestParam("price") BigDecimal price,
                            @RequestParam("description") String description,
                            @RequestParam("category") String category
                           )
    // @RequestBody ProductRequest request
    {
        impl.addNewProduct(image,productName,price,description,category);
    }

    @GetMapping(value = "/products")
    public List<Product> getAllProducts(){
        return impl.getAllProducts();
    }

    @GetMapping(value = "/products/{category}")
    public List<Product> getAllProductByCategory(@PathVariable String category){
        return impl.getAllProducts();
    }
}
