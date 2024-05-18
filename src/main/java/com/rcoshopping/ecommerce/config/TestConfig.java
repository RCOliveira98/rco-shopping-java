package com.rcoshopping.ecommerce.config;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rcoshopping.ecommerce.entities.CategoryEntity;
import com.rcoshopping.ecommerce.entities.OrderEntity;
import com.rcoshopping.ecommerce.entities.UserEntity;

import com.rcoshopping.ecommerce.enums.OrderStatus;

import com.rcoshopping.ecommerce.repositories.CategoryRepository;
import com.rcoshopping.ecommerce.repositories.OrderRepository;
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
    }
}
