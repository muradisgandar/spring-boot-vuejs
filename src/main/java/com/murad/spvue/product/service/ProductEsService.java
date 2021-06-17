package com.murad.spvue.product.service;

import com.murad.spvue.product.domain.Product;
import com.murad.spvue.product.domain.es.CategoryEs;
import com.murad.spvue.product.domain.es.CompanyEs;
import com.murad.spvue.product.domain.es.ProductEs;
import com.murad.spvue.repository.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductEsService {

    private final ProductEsRepository productEsRepository;

    public Mono<ProductEs> saveNewProduct(Product product){
        return productEsRepository.save(ProductEs.builder()
                .active(product.getActive())
                .code(product.getCode())
                .description(product.getDescription())
                .features(product.getFeatures())
                .id(product.getId())
                .name(product.getName())
                // TODO get company name and code
                .seller(CompanyEs.builder().id(product.getCompanyId()).name("Test").build())
                .category(CategoryEs.builder().id(product.getCategoryId()).name("Test").build())
                .build());

    }

    public Flux<ProductEs> findAll() {
        return productEsRepository.findAll();
    }
}
