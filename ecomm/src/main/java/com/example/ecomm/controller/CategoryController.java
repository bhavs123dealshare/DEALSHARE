package com.example.ecomm.controller;

import com.example.ecomm.entity.Category;
import com.example.ecomm.entity.Product;
import com.example.ecomm.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryservice;


    @PostMapping("/AddCategory")
    public Category postDetails(@RequestBody Category category)
    {
         return categoryservice.saveDetails(category);
    }

    @GetMapping("/GetCategories")
    public List<Category> GetAllProducts()
    {
        return categoryservice.GetAllCategories();
    }



    @PutMapping("update/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable int id, @RequestBody Category updatedCategory) {
        Category category= categoryservice.updateCategory(id, updatedCategory);
        if (category != null) {
            return ResponseEntity.ok(category);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        categoryservice.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }

}
