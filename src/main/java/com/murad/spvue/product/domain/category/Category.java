package com.murad.spvue.product.domain.category;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "category")
@Data
@Builder
public class Category {

    @Id
    private String id;
    private String name;
    private String code;
}
