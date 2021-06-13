package com.murad.spvue.product.domain.es;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "product")
@Data
public class ProductEs {

    private String id;
    private String name;
    private String code;
    private String description;
    private CompanyEs seller;
    private String features;
    private CategoryEs category;
    private Boolean active;
}
