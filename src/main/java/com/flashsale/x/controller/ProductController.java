package com.flashsale.x.controller;

import com.flashsale.x.common.page.PageResult;
import com.flashsale.x.common.result.Result;
import com.flashsale.x.domain.vo.ProductDetailVO;
import com.flashsale.x.domain.vo.ProductListItemVO;
import com.flashsale.x.service.ProductService;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public Result<PageResult<ProductListItemVO>> listProducts(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) String keyword,
            @RequestParam(required = false, defaultValue = "1") Integer status,
            @RequestParam(defaultValue = "1") @Min(value = 1, message = "页码不能小于1") Long page,
            @RequestParam(defaultValue = "10") @Min(value = 1, message = "每页数量不能小于1") @Max(value = 100, message = "每页数量不能超过100") Long size
    ) {
        PageResult<ProductListItemVO> result = productService.listProducts(categoryId, keyword, status, page, size);
        return Result.success(result);
    }

    @GetMapping("/api/products/{id}")
    public Result<ProductDetailVO> getProductDetail(
            @PathVariable @Min(value = 1, message = "商品ID不能小于1") Long id
    ) {
        ProductDetailVO productDetail = productService.getProductDetail(id);
        return Result.success(productDetail);
    }
}