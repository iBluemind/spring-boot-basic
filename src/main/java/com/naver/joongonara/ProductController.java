package com.naver.joongonara;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PostMapping
    @ResponseBody
    Product sell(@RequestBody Product requestedProduct) {
        Product createdProduct = new Product();

        createdProduct.setName(requestedProduct.getName());
        createdProduct.setDescription(requestedProduct.getDescription());
        createdProduct.setPrice(requestedProduct.getPrice());

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(createdProduct);
            entityTransaction.commit();
        } catch(Exception error) {
            error.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        return createdProduct;
    }
}
