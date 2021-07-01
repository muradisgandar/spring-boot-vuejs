package com.murad.spvue.product.service;

import com.murad.spvue.product.domain.MoneyTypes;
import com.murad.spvue.product.domain.Product;
import com.murad.spvue.product.domain.ProductImage;
import com.murad.spvue.product.domain.es.ProductEs;
import com.murad.spvue.product.model.product.ProductDetailResponse;
import com.murad.spvue.product.model.product.ProductResponse;
import com.murad.spvue.product.model.product.ProductSaveRequest;
import com.murad.spvue.product.model.ProductSellerResponse;
import com.murad.spvue.product.repository.mongo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductEsService productEsService;

    public Flux<ProductResponse> getAll(){
        return productEsService.findAll().map(this::mapToDto);
    }

    public ProductResponse save(ProductSaveRequest request){
        Product product = Product.builder()
                .active(Boolean.TRUE)
                .code("PR0001")
                .categoryId(request.getCategoryId())
                .companyId(request.getSellerId())
                .description(request.getDescription())
                .features(request.getFeatures())
                .name(request.getName())
                .price(request.getPrice())
                .productImageList(request.getImages()
                        .stream()
                        .map(item -> new ProductImage(ProductImage.ImageType.FEATURE,item))
                        .collect(Collectors.toList()))
                .build();

        product = productRepository.save(product).block();


        return this.mapToDto(productEsService.saveNewProduct(product).block());
    }

    private ProductResponse mapToDto(ProductEs item) {

        if(item == null){
            return null;
        }

        return ProductResponse.builder()
                .price(BigDecimal.TEN) // null pointer throws
                .moneySymbol(MoneyTypes.USD.getSymbol())
                .name(item.getName())
                .features(item.getFeatures())
                .id(item.getId())
                .description(item.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
                .categoryId(item.getCategory().getId())
                .available(productAmountService.getByProductId(item.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(item.getId(), BigDecimal.TEN, MoneyTypes.USD))
                .image(item.getImages().get(0))
                .seller(ProductSellerResponse.builder().id(item.getSeller().getId()).name(item.getSeller().getName()).build())
                .build();


    }

    public Mono<Long> count() {
        return productRepository.count();
    }

    public Mono<ProductDetailResponse> getProductDetail(String id) {
        return this.mapToDto(productEsService.findById(id));
    }
}
