package com.murad.spvue.product.api;

import com.murad.spvue.product.model.category.CategoryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class CategoryApi {

    @GetMapping
    public Flux<CategoryResponse> getAll(){

    }
}
