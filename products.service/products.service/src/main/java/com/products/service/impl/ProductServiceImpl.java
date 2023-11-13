package com.products.service.impl;

import com.products.service.config.AmazonClient;
import com.products.service.dto.ProductCategory;
import com.products.service.dto.ProductRequest;
import com.products.service.entity.Product;
import com.products.service.exception.NotFoundException;
import com.products.service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    private final AmazonClient amazonClient;

    @Override
    public void addNewProduct(MultipartFile productImage,
                              String productName, BigDecimal price, String description,
                              String category) {
        String productUrl = amazonClient.uploadFile(productImage);
        Product product = new Product(productName,
               price,description, ProductCategory.valueOf(category),productUrl);
        repository.save(product);
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        return Optional.ofNullable(repository.findAllByCategory(category)).orElseThrow(() -> new NotFoundException("Products with category not found"));
    }

    @Override
    public Product getProductById(Long id) {
        return Optional.ofNullable(repository.findProductById(id)).orElseThrow(() -> new NotFoundException("Product with ID not found"));
    }

    @Override
    public List<Product> getAllProducts() {
        return repository.findAll();
           }

    @Override
    public List<Product> getProductByName(String name) {
        return Optional.ofNullable(repository.findProductByName(name)).orElseThrow(() -> new NotFoundException("Products with name not found"));
    }

    @Override
    public void deleteProduct(Long id){
        repository.deleteById(id);
    }
}
