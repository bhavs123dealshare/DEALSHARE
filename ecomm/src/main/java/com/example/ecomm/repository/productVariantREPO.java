package com.example.ecomm.repository;

import com.example.ecomm.entity.Product;
import com.example.ecomm.entity.ProductVariants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface productVariantREPO extends JpaRepository<ProductVariants,Integer> {
    List<ProductVariants> findByProductId(int productId);

}
