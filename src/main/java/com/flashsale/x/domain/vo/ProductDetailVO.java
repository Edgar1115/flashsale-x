package com.flashsale.x.domain.vo;

import com.flashsale.x.domain.entity.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ProductDetailVO {

    private Long id;

    private String name;

    private Long categoryId;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private String coverUrl;

    private String description;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public static ProductDetailVO from(Product product) {
        ProductDetailVO vo = new ProductDetailVO();

        vo.setId(product.getId());
        vo.setName(product.getName());
        vo.setCategoryId(product.getCategoryId());
        vo.setPrice(product.getPrice());
        vo.setStock(product.getStock());
        vo.setStatus(product.getStatus());
        vo.setCoverUrl(product.getCoverUrl());
        vo.setDescription(product.getDescription());
        vo.setCreatedAt(product.getCreatedAt());
        vo.setUpdatedAt(product.getUpdatedAt());

        return vo;
    }
}