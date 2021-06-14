package com.murad.spvue.product.service;

import com.murad.spvue.product.domain.es.ProductEs;
import com.murad.spvue.product.model.ProductResponse;
import com.murad.spvue.product.model.ProductSaveRequest;
import com.murad.spvue.product.repository.mongo.ProductRepository;
import com.murad.spvue.repository.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;

    public Flux<ProductResponse> getAll(Pageable pageable){
        return productEsRepository.findAll().map(this::mapToDto);
    }

    ProductResponse save(ProductSaveRequest productSaveRequest){
        return null;
    }

    private ProductResponse mapToDto(ProductEs productEs) {
        return null;
    }

}
