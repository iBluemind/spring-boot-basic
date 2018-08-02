package com.naver.joongonara.service;

import com.naver.joongonara.dao.ProductRepository;
import com.naver.joongonara.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;


    public Product detail(int id) {
        Product existedProduct = productRepository.getOne(id);
        return existedProduct;
    }


    public Product sell(Product newProduct) {
        Product createdProduct = new Product();

        createdProduct.setName(newProduct.getName());
        createdProduct.setDescription(newProduct.getDescription());
        createdProduct.setPrice(newProduct.getPrice());

        return productRepository.save(createdProduct);
    }
}
