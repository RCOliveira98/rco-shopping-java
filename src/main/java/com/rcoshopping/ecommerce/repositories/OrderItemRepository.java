package com.rcoshopping.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rcoshopping.ecommerce.entities.OrderItemEntity;
import com.rcoshopping.ecommerce.entities.pk.OrderItemPkEntity;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, OrderItemPkEntity> {

}
