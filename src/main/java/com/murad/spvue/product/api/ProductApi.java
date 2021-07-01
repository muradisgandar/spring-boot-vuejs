package com.murad.spvue.product.api;

import com.murad.spvue.product.model.product.ProductDetailResponse;
import com.murad.spvue.product.model.product.ProductResponse;
import com.murad.spvue.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductApi {

    private final ProductService productService;

    @GetMapping
    public Flux<ProductResponse> getAllProducts(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<ProductDetailResponse> getProductDetail(@PathVariable("id") String id){
        return productService.getProductDetail(id);
    }
}
