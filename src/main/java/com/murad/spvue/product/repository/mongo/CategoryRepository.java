package com.murad.spvue.product.repository.mongo;

import com.murad.spvue.product.domain.category.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends ReactiveMongoRepository<Category, String> {
}
