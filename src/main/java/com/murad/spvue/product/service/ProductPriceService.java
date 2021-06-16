package com.murad.spvue.product.service;

import com.murad.spvue.product.domain.MoneyTypes;
import com.murad.spvue.product.repository.mongo.ProductPriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductPriceService {

    private final ProductPriceRepository productPriceRepository;

    public BigDecimal getByMoneyType(String id, MoneyTypes usd) {
        return BigDecimal.TEN;
    }
}
