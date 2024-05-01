package com.rcoshopping.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcoshopping.ecommerce.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
