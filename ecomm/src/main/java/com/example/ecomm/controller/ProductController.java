package com.example.ecomm.controller;

import com.example.ecomm.entity.Product;
import com.example.ecomm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productservice;

    @PostMapping("/AddProducts")
    public Product postDetails(@RequestBody Product product)
    {
        return productservice.saveDetails(product);
    }

    @GetMapping("/GetProducts")
    public List<Product> GetAllProduct()
    {
        return productservice.GetAllProducts();
    }

    @GetMapping("/GetProducts/{category_id}")
    public ResponseEntity<List<Product>> GetAllProductsByCategoryId(@PathVariable(value = "category_id") int categoryId)
    {
        List<Product> products =  productservice.GetAllProductsByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        Product product = productservice.updateProduct(id, updatedProduct);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productservice.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }

}


