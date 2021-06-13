package com.murad.spvue.product.domain;

public class ProductImage {

    private ImageType imageType;
    private String url;

    enum ImageType {
        FEATURE, NORMAL;
    }
}
