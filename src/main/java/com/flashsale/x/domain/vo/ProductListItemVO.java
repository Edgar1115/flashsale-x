package com.flashsale.x.domain.vo;

import com.flashsale.x.domain.entity.Product;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductListItemVO {

    private Long id;

    private String name;

    private Long categoryId;

    private BigDecimal price;

    private Integer stock;

    private Integer status;

    private String coverUrl;

    public static ProductListItemVO from(Product product) {
        ProductListItemVO vo = new ProductListItemVO();

        vo.setId(product.getId());
        vo.setName(product.getName());
        vo.setCategoryId(product.getCategoryId());
        vo.setPrice(product.getPrice());
        vo.setStock(product.getStock());
        vo.setStatus(product.getStatus());
        vo.setCoverUrl(product.getCoverUrl());

        return vo;
    }
}