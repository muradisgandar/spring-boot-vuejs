package com.murad.spvue.product.model.product;

import com.murad.spvue.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Builder
@Data
public class ProductSaveRequest {

    private String id;
    private String name;
    private String description;
    private String features;
    private BigDecimal available;
    private Map<MoneyTypes, BigDecimal> price;
    private List<String> images;
    private String sellerId;
    private String categoryId;
}
