package com.flashsale.x.common.page;

import lombok.Data;

import java.util.List;

@Data
public class PageResult<T> {

    private Long total;

    private Long page;

    private Long size;

    private List<T> records;

    public PageResult(Long total, Long page, Long size, List<T> records) {
        this.total = total;
        this.page = page;
        this.size = size;
        this.records = records;
    }

    public static <T> PageResult<T> of(Long total, Long page, Long size, List<T> records) {
        return new PageResult<>(total, page, size, records);
    }
}