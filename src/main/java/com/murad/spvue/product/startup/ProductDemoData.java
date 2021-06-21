package com.murad.spvue.product.startup;

import com.murad.spvue.product.domain.MoneyTypes;
import com.murad.spvue.product.model.category.CategoryResponse;
import com.murad.spvue.product.model.category.CategorySaveRequest;
import com.murad.spvue.product.model.product.ProductSaveRequest;
import com.murad.spvue.product.service.ProductService;
import com.murad.spvue.product.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.UUID.randomUUID;

@Component
@RequiredArgsConstructor
public class ProductDemoData {

    private final ProductService productService;
    private final CategoryService categoryService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){
        Long countOfData = productService.count().block();
        if (countOfData.equals(0L)) {
            CategoryResponse electronics = categoryService.save(CategorySaveRequest.builder().name("Electronics").build());
            CategoryResponse telephone = categoryService.save(CategorySaveRequest.builder().name("Telephone").build());

            IntStream.range(0, 20).forEach(item -> {
                productService.save(
                        ProductSaveRequest.builder()
                                .sellerId(randomUUID().toString())
                                .id(randomUUID().toString())
                                .description("Product Description " + item)
                                .money(MoneyTypes.USD)
                                .categoryId(telephone.getId())
                                .name("Product Name " + item)
                                .features("<li>Black Color</li> <li>Aluminum Case</li> <li>2 Years Warranty</li> <li>5 Inch (35x55mm)</li>")
                                .price(BigDecimal.TEN)
                                .images(List.of("https://productimages.hepsiburada.net/s/32/500/10352568139826.jpg"))
                                .build());
            });
        }
    }
}
