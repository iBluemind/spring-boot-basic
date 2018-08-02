package com.naver.joongonara.controller;

import com.naver.joongonara.domain.entity.Product;
import com.naver.joongonara.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(path = "/{id}")
    @ResponseBody
    Product detail(@PathVariable int id) {
        return productService.detail(id);
    }

    @PostMapping
    @ResponseBody
    Product sell(@RequestBody Product requestedProduct) {
        return productService.sell(requestedProduct);
    }
}
