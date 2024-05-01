package com.rcoshopping.ecommerce.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.rcoshopping.ecommerce.entities.UserEntity;
import com.rcoshopping.ecommerce.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        UserEntity userFirst = new UserEntity(null, "Brenda Rainara", "brenda@email.com", "89994505050", "brendaSenha");
        UserEntity userLast = new UserEntity(null, "Romário Coelho", "romario@email.com", "89994303030", "romarioSenha");
        List<UserEntity> listUser = Arrays.asList(userFirst, userLast);
        userRepository.saveAll(listUser);
    }
}
