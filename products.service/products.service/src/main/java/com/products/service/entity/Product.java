package com.products.service.entity;

import com.products.service.dto.ProductCategory;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class Product {

    @SequenceGenerator(
            name = "users_sequence",
            sequenceName = "users_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_sequence"
    )
    private Long id;

    private String name;

    private BigDecimal price;

    private String description;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;

    private boolean availability = true;

    private String productUrl;

    public Product(String name, BigDecimal price, String description, ProductCategory category, String productUrl) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.productUrl = productUrl;
    }
}
