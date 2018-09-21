package org.bookshop.system.app.serviceimpl;

import java.util.List;

import org.bookshop.system.app.model.entity.Category;
import org.bookshop.system.app.repositories.CategoryRepository;
import org.bookshop.system.app.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void saveCategoriesIntoDb(List<Category> categories) {
        this.categoryRepository.saveAll(categories);
    }

    @Override
    public List<Category> getAll() {
        return this.categoryRepository.findAll();
    }
}
