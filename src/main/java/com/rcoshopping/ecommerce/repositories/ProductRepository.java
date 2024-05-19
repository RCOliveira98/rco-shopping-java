package com.rcoshopping.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcoshopping.ecommerce.entities.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
