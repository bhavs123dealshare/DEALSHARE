package com.example.ecomm.service;

import com.example.ecomm.entity.Category;
import com.example.ecomm.entity.Product;
import com.example.ecomm.repository.categoryREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private categoryREPO categoryrepo;
    public Category saveDetails(Category category)
    {
        return categoryrepo.save(category);
    }
    public List<Category> GetAllCategories()
    {
        return categoryrepo.findAll();
    }

    public Category updateCategory(int id, Category updatedCategory) {
        Category existingCategory = categoryrepo.findById(id).orElse(null);

        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            return categoryrepo.save(existingCategory);
        }

        return null; // Product not found
    }

    public void deleteCategory(int id) {
        categoryrepo.deleteById(id);
    }

}
