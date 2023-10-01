package com.learnwithvjk.productservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.learnwithvjk.productservice.dto.ProductRequest;
import com.learnwithvjk.productservice.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productservice;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(ProductRequest productRequest) {
        productservice.createProduct(productRequest);
    }

}
