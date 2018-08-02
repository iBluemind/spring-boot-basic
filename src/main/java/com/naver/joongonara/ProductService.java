package com.naver.joongonara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
