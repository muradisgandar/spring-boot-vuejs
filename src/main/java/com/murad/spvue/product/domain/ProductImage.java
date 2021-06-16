package com.murad.spvue.product.domain;

import lombok.Data;

@Data
public class ProductImage {

    private ImageType imageType;
    private String url;

    public enum ImageType {
        FEATURE, NORMAL;
    }
}
