package com.murad.spvue.product.service;

import com.murad.spvue.product.model.ProductResponse;
import com.murad.spvue.product.model.ProductSaveRequest;
import com.murad.spvue.product.repository.mongo.ProductRepository;
import com.murad.spvue.repository.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;

    List<ProductResponse> getByPaging(Pageable pageable){
        return null;
    }

    ProductResponse save(ProductSaveRequest productSaveRequest){
        return null;
    }
}
