package ru.volnenko.cloud.testhub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.volnenko.cloud.testhub.model.Category;
import ru.volnenko.cloud.testhub.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryServiceBean implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(String s) {
        return categoryRepository.findById(s);
    }

}
