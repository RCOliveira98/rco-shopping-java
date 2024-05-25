package com.rcoshopping.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.rcoshopping.ecommerce.entities.UserEntity;
import com.rcoshopping.ecommerce.repositories.UserRepository;
import com.rcoshopping.ecommerce.services.exceptions.DatabaseExceptionService;
import com.rcoshopping.ecommerce.services.exceptions.ResourceNotFoundExceptionService;

import jakarta.persistence.EntityNotFoundException;

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
		try {
            this.userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundExceptionService(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseExceptionService(e.getMessage());
        }
	}

    public UserEntity update(Long id, UserEntity obj) {
        try {
			UserEntity entity = userRepository.getReferenceById(id);
			updateData(entity, obj);
			return userRepository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundExceptionService(id);
		}
	}

	private void updateData(UserEntity entity, UserEntity obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}
}
