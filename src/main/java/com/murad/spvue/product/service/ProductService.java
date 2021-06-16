package com.murad.spvue.product.service;

import com.murad.spvue.product.domain.MoneyTypes;
import com.murad.spvue.product.domain.es.ProductEs;
import com.murad.spvue.product.model.ProductResponse;
import com.murad.spvue.product.model.ProductSaveRequest;
import com.murad.spvue.product.model.ProductSellerResponse;
import com.murad.spvue.product.repository.mongo.ProductRepository;
import com.murad.spvue.repository.ProductEsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductEsRepository productEsRepository;
    private final ProductRepository productRepository;
    private final ProductPriceService productPriceService;
    private final ProductDeliveryService productDeliveryService;
    private final ProductAmountService productAmountService;
    private final ProductImageService productImageService;

    public Flux<ProductResponse> getAll(){
        return productEsRepository.findAll().map(this::mapToDto);
    }

    ProductResponse save(ProductSaveRequest productSaveRequest){
        return null;
    }

    private ProductResponse mapToDto(ProductEs item) {
        BigDecimal productPrice = productPriceService.getByMoneyType(item.getId(), MoneyTypes.USD);
        return ProductResponse.builder()
                .price(productPrice)
                .name(item.getName())
                .features(item.getFeatures())
                .id(item.getId())
                .description(item.getDescription())
                .deliveryIn(productDeliveryService.getDeliveryInfo(item.getId()))
                .categoryId(item.getCategory().getId())
                .available(productAmountService.getByProductId(item.getId()))
                .freeDelivery(productDeliveryService.freeDeliveryCheck(item.getId(), productPrice))
                .moneyType(MoneyTypes.USD)
                .image(productImageService.getProductMainImage(item.getId()))
                .seller(ProductSellerResponse.builder().id(item.getSeller().getId()).name(item.getSeller().getName()).build())
                .build();


    }

}
