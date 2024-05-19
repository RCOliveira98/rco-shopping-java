package com.rcoshopping.ecommerce.entities.pk;

import com.rcoshopping.ecommerce.entities.OrderEntity;
import com.rcoshopping.ecommerce.entities.ProductEntity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OrderItemPkEntity {
    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
    
    public OrderEntity getOrder() {
        return order;
    }
    public void setOrder(OrderEntity order) {
        this.order = order;
    }
    public ProductEntity getProduct() {
        return product;
    }
    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((order == null) ? 0 : order.hashCode());
        result = prime * result + ((product == null) ? 0 : product.hashCode());
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
        OrderItemPkEntity other = (OrderItemPkEntity) obj;
        if (order == null) {
            if (other.order != null)
                return false;
        } else if (!order.equals(other.order))
            return false;
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        return true;
    }
}
