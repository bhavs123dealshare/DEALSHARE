package com.example.ecomm.service;


import com.example.ecomm.entity.Product;
import com.example.ecomm.repository.productREPO;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private productREPO productrepo;
    public Product saveDetails(Product product)
    {

        return productrepo.save(product);
    }

    public List<Product> GetAllProducts()
    {
        return productrepo.findAll();
    }
    public List<Product> GetAllProductsByCategoryId(int categoryId) {
        return productrepo.findByCategoryId(categoryId);
    }

    public Product updateProduct(int id, Product updatedProduct) {
        Product existingProduct = productrepo.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setDescription(updatedProduct.getDescription());
            existingProduct.setCategoryId(updatedProduct.getCategoryId());
            return productrepo.save(existingProduct);
        }

        return null; // Product not found
    }


    public void deleteProduct(int id) {
        productrepo.deleteById(id);
    }
}

