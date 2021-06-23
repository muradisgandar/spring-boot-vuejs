package com.murad.spvue.product.service;

import com.murad.spvue.product.domain.MoneyTypes;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductDeliveryService {

    public String getDeliveryInfo(String productId){
        return "Tomorrow";
    }

    public boolean freeDeliveryCheck(String productId, BigDecimal price, MoneyTypes moneyType){
        return true;
    }
}
