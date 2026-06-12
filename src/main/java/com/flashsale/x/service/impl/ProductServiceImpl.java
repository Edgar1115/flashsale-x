package com.flashsale.x.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flashsale.x.common.exception.BusinessException;
import com.flashsale.x.common.page.PageResult;
import com.flashsale.x.common.result.ResultCode;
import com.flashsale.x.domain.entity.Product;
import com.flashsale.x.domain.vo.ProductDetailVO;
import com.flashsale.x.domain.vo.ProductListItemVO;
import com.flashsale.x.mapper.ProductMapper;
import com.flashsale.x.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public PageResult<ProductListItemVO> listProducts(Long categoryId, String keyword, Integer status, Long page, Long size) {
        LambdaQueryWrapper<Product> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(categoryId != null, Product::getCategoryId, categoryId);
        queryWrapper.eq(status != null, Product::getStatus, status);
        queryWrapper.like(StringUtils.hasText(keyword), Product::getName, keyword);
        queryWrapper.orderByDesc(Product::getCreatedAt);

        Page<Product> pageParam = new Page<>(page, size);
        Page<Product> productPage = this.page(pageParam, queryWrapper);

        List<ProductListItemVO> records = productPage.getRecords()
                .stream()
                .map(ProductListItemVO::from)
                .toList();

        return PageResult.of(
                productPage.getTotal(),
                productPage.getCurrent(),
                productPage.getSize(),
                records
        );
    }

    @Override
    public ProductDetailVO getProductDetail(Long id) {
        Product product = this.getById(id);

        if (product == null) {
            throw new BusinessException(ResultCode.NOT_FOUND, "商品不存在");
        }

        return ProductDetailVO.from(product);
    }
}