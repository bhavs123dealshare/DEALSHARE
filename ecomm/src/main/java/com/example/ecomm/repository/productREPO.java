package com.example.ecomm.repository;

import java.util.*;
import com.example.ecomm.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface productREPO extends JpaRepository<Product,Integer> {
    List<Product> findByCategoryId(int categoryId);
}


