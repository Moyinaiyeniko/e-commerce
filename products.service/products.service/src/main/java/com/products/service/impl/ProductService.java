package com.products.service.impl;

import com.products.service.dto.ProductRequest;
import com.products.service.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addNewProduct(MultipartFile productImage, String productName, BigDecimal price, String description,
                       String category);

    List<Product> getAllProductByCategory(String category);

    Product getProductById(Long id);

    List<Product> getAllProducts();

    List<Product> getProductByName(String name);

    void deleteProduct(Long id);
}
