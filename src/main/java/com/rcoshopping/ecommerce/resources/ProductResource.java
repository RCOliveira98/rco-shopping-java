package com.rcoshopping.ecommerce.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcoshopping.ecommerce.entities.ProductEntity;
import com.rcoshopping.ecommerce.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll() {
        List<ProductEntity> list = this.productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable Long id) {
        ProductEntity product = this.productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
