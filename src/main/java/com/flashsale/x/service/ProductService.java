package com.flashsale.x.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.flashsale.x.common.page.PageResult;
import com.flashsale.x.domain.entity.Product;
import com.flashsale.x.domain.vo.ProductDetailVO;
import com.flashsale.x.domain.vo.ProductListItemVO;

public interface ProductService extends IService<Product> {

    PageResult<ProductListItemVO> listProducts(Long categoryId, String keyword, Integer status, Long page, Long size);

    ProductDetailVO getProductDetail(Long id);
}