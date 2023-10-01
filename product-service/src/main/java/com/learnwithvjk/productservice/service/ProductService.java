package com.learnwithvjk.productservice.service;

import org.springframework.stereotype.Service;

import com.learnwithvjk.productservice.dto.ProductRequest;
import com.learnwithvjk.productservice.model.Product;
import com.learnwithvjk.productservice.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        productRepository.save(product);
        log.info("product {} is saved", product.getId());
    }

}
