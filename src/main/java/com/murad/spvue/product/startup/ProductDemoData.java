package com.murad.spvue.product.startup;

import com.murad.spvue.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductDemoData {

    private final ProductService productService;

    @EventListener(ApplicationReadyEvent.class)
    public void migrate(){

    }
}
