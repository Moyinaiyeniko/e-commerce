package com.products.service.repository;

import com.products.service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM products p WHERE p.id=:id", nativeQuery = true)
    Product findProductById(Long id);

    @Query(value = "SELECT * FROM products p WHERE p.category=:category", nativeQuery = true)
    List<Product> findAllByCategory(String category);

    @Query(value = "SELECT * FROM products p WHERE p.name=:name", nativeQuery = true)
    List<Product> findProductByName(String name);

    List<Product> findAll();
}
