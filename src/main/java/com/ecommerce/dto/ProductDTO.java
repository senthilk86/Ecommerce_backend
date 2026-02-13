package com.ecommerce.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stockQuantity;
    private String imageUrl;
    private String specifications;
    private Long categoryId;
    private String categoryName;
    private Boolean active;
}
