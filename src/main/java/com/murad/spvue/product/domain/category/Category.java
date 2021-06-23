package com.murad.spvue.product.domain.category;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@Data
@Builder
public class Category {

    @Id
    private String id;
    private String name;
    private String code;
}
