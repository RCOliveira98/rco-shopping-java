package com.rcoshopping.ecommerce.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcoshopping.ecommerce.entities.UserEntity;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<UserEntity> findAll() {
        UserEntity user = new UserEntity(1L, "Romário Coelho", "romario.email@email.com", "(89)994001122", "minhaSenha");
        return ResponseEntity.ok().body(user);
    }
}
