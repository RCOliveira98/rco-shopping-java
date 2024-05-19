package com.rcoshopping.ecommerce.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rcoshopping.ecommerce.entities.UserEntity;
import com.rcoshopping.ecommerce.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserEntity> postMethodName(@RequestBody UserEntity user) {
        user = userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }
    

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAll() {
        List<UserEntity> list = this.userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserEntity> findById(@PathVariable Long id) {
        UserEntity user = this.userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.userService.delete(id);
		return ResponseEntity.noContent().build();
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<UserEntity> update(@PathVariable Long id, @RequestBody UserEntity obj) {
		obj = this.userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
}
