package com.fashionstore.service;
import java.util.List;

import com.fashionstore.entity.Category;

public interface CategoryService {

    Category getCategoryById(Long categoryId);

    List<Category> getAllCategories();

    Category createCategory(Category category);

    Category updateCategory(Category category);

    void deleteCategory(Long categoryId);
}
