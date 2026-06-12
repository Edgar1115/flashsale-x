package com.flashsale.x.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.flashsale.x.domain.entity.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}