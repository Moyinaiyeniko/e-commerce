package com.products.service.dto;

import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public record ProductRequest(
        String productName,
        BigDecimal price,
        String description,
        ProductCategory category

) {
}
