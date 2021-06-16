package com.murad.spvue.product.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "product-price")
@Data
public class ProductPrice {

    private String id;
    private String productId;
    private MoneyTypes moneyType;
    private String price;
}
