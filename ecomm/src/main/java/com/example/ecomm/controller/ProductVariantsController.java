package com.example.ecomm.controller;

import com.example.ecomm.entity.Product;
import com.example.ecomm.entity.ProductVariants;
import com.example.ecomm.service.ProductVariantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productVariants")
public class ProductVariantsController {
   @Autowired
    private ProductVariantsService productVariantsService;


    @PostMapping("/AddProductVariants")
    public ProductVariants postDetails(@RequestBody ProductVariants productVariants)
    {
        return productVariantsService.saveDetails(productVariants);
    }

    @GetMapping("/GetProductVariants")
    public List<ProductVariants> GetAllProducts()
    {
        return productVariantsService.GetAllProductVariants();
    }

    @GetMapping("/GetProductVariants/{product_id}")
    public ResponseEntity<List<ProductVariants>> GetProductVariantsByProductId(@PathVariable(value = "product_id") int productId)
    {
        List<ProductVariants> productVariants =  productVariantsService.GetProductVariantsByProductId(productId);
        return ResponseEntity.ok(productVariants);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ProductVariants> updateProductVariants(@PathVariable int id, @RequestBody ProductVariants updatedProductVariants) {
        ProductVariants productvariants = productVariantsService.updateProductVariants(id, updatedProductVariants);

        if (productvariants != null) {
            return ResponseEntity.ok(productvariants);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("Delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productVariantsService.deleteProductVariants(id);
        return ResponseEntity.noContent().build();
    }


}









