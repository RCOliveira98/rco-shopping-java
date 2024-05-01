package com.rcoshopping.ecommerce.enums;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getOrderStatus() {
        return this.code;
    }

    public static OrderStatus transform(int code) {
        for(OrderStatus value : OrderStatus.values()) {
            if (value.code == code) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid code OrderStatus");
    }
}
