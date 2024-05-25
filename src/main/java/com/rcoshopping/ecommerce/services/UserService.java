package com.rcoshopping.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoshopping.ecommerce.entities.UserEntity;
import com.rcoshopping.ecommerce.repositories.UserRepository;
import com.rcoshopping.ecommerce.services.exceptions.ResourceNotFoundExceptionService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> findAll() {
        return this.userRepository.findAll();
    }

    public UserEntity findById(Long id) {
        Optional<UserEntity> obj = this.userRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundExceptionService(id));
    }

    public UserEntity insert(UserEntity userEntity) {
        return this.userRepository.save(userEntity);
    }

    public void delete(Long id) {
		this.userRepository.deleteById(id);
	}

    public UserEntity update(Long id, UserEntity obj) {
		UserEntity entity = this.userRepository.getReferenceById(id);
		updateData(entity, obj);
		return userRepository.save(entity);
	}

	private void updateData(UserEntity entity, UserEntity obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
