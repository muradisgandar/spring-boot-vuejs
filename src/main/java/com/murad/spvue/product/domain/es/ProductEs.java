package com.murad.spvue.product.domain.es;

import com.murad.spvue.product.domain.MoneyTypes;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(indexName = "product")
@Data
@Builder
public class ProductEs {

    @Id
    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String features;
    private CategoryEs category;
    private Map<MoneyTypes, BigDecimal> price;
    private List<String> images;
    private Boolean active;
}
