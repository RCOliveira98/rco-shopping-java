package com.rcoshopping.ecommerce.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rcoshopping.ecommerce.entities.CategoryEntity;
import com.rcoshopping.ecommerce.entities.OrderEntity;
import com.rcoshopping.ecommerce.entities.OrderItemEntity;
import com.rcoshopping.ecommerce.entities.PaymentEntity;
import com.rcoshopping.ecommerce.entities.ProductEntity;
import com.rcoshopping.ecommerce.entities.UserEntity;

import com.rcoshopping.ecommerce.enums.OrderStatus;

import com.rcoshopping.ecommerce.repositories.CategoryRepository;
import com.rcoshopping.ecommerce.repositories.OrderItemRepository;
import com.rcoshopping.ecommerce.repositories.OrderRepository;
import com.rcoshopping.ecommerce.repositories.ProductRepository;
import com.rcoshopping.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userFirst = new UserEntity(null, "Brenda Rainara", "brenda@email.com", "89994505050", "brendaSenha");
        UserEntity userLast = new UserEntity(null, "Romário Coelho", "romario@email.com", "89994303030", "romarioSenha");
        List<UserEntity> listUser = Arrays.asList(userFirst, userLast);
        userRepository.saveAll(listUser);

        OrderEntity order1 = new OrderEntity(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.WAITING_PAYMENT, userFirst);
        OrderEntity order2 = new OrderEntity(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.PAID, userLast);
        OrderEntity order3 = new OrderEntity(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, userFirst);
        orderRepository.saveAll(Arrays.asList(order1, order2, order3));

        CategoryEntity cat1 = new CategoryEntity(null, "Electronics");
        CategoryEntity cat2 = new CategoryEntity(null, "Books");
        CategoryEntity cat3 = new CategoryEntity(null, "Computers");

        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

        ProductEntity p1 = new ProductEntity(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        ProductEntity p2 = new ProductEntity(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        ProductEntity p3 = new ProductEntity(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        ProductEntity p4 = new ProductEntity(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        ProductEntity p5 = new ProductEntity(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        p1.getCategories().add(cat3);
        p1.getCategories().add(cat1);
        p2.getCategories().add(cat1);
        p3.getCategories().add(cat2);
        p4.getCategories().add(cat3);
        p5.getCategories().add(cat1);
        productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

        OrderItemEntity oi1 = new OrderItemEntity(order1, p1, 2, p1.getPrice());
        OrderItemEntity oi2 = new OrderItemEntity(order1, p3, 1, p3.getPrice());
        OrderItemEntity oi3 = new OrderItemEntity(order2, p3, 2, p3.getPrice());
        OrderItemEntity oi4 = new OrderItemEntity(order3, p5, 2, p5.getPrice());
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

        PaymentEntity pay1 = new PaymentEntity(null, Instant.now(), order1);
        order1.setPayment(pay1);
        orderRepository.save(order1);
    }
}
