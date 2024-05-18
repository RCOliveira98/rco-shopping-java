package com.rcoshopping.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcoshopping.ecommerce.entities.CategoryEntity;
import com.rcoshopping.ecommerce.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> findAll() {
        return this.categoryRepository.findAll();
    }

    public CategoryEntity findById(Long id) {
        Optional<CategoryEntity> category = this.categoryRepository.findById(id);
        return category.get();
    }

    public CategoryEntity insert(CategoryEntity CategoryEntity) {
        return this.categoryRepository.save(CategoryEntity);
    }
}
