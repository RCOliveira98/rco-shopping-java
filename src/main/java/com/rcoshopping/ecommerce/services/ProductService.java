package com.rcoshopping.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoshopping.ecommerce.entities.ProductEntity;
import com.rcoshopping.ecommerce.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> findAll() {
        return this.productRepository.findAll();
    }

    public ProductEntity findById(Long id) {
        Optional<ProductEntity> product = this.productRepository.findById(id);
        return product.get();
    }

    public ProductEntity insert(ProductEntity product) {
        return this.productRepository.save(product);
    }
}
