package com.rcoshopping.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoshopping.ecommerce.entities.UserEntity;
import com.rcoshopping.ecommerce.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return this.userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        Optional<UserEntity> user = this.userRepository.findById(id);
        return user.get();
    }

    public UserEntity insert(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }
}
