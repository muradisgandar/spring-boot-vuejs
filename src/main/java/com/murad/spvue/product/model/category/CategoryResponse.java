package com.murad.spvue.product.model.category;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {

    private String id;
    private String name;
}
