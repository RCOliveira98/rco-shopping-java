package com.rcoshopping.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rcoshopping.ecommerce.entities.pk.OrderItemPkEntity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItemEntity {
    @EmbeddedId
    private OrderItemPkEntity id = new OrderItemPkEntity();
    private Integer quantity;
    private Double price;

    public OrderItemEntity() {}

    public OrderItemEntity(OrderEntity order, ProductEntity product, Integer quantity, Double price) {
        this.quantity = quantity;
        this.price = price;
        this.id.setOrder(order);
        this.id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @JsonIgnore
    public OrderEntity getOrder() {
        return this.id.getOrder();
    }

    public void setOrder(OrderEntity order) {
        this.id.setOrder(order);
    }

    public ProductEntity getProduct() {
        return this.id.getProduct();
    }

    public void setProduct(ProductEntity product) {
        this.id.setProduct(product);
    }

    public Double getSubTotal() {
        return this.quantity * this.price;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        OrderItemEntity other = (OrderItemEntity) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    
}
