package org.bookshop.system.app.service;

import java.util.List;

import org.bookshop.system.app.model.entity.Category;

public interface CategoryService {

    void saveCategoriesIntoDb(List<Category> categories);

    List<Category> getAll();
}
