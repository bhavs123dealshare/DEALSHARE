package com.example.ecomm.service;

import com.example.ecomm.entity.Product;
import com.example.ecomm.entity.ProductVariants;
import com.example.ecomm.repository.productVariantREPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductVariantsService {
    @Autowired
    private productVariantREPO productvariantsrepo;
    public ProductVariants saveDetails(ProductVariants productvariants)
    {

        return productvariantsrepo.save(productvariants);
    }

    public List<ProductVariants> GetAllProductVariants()
    {

        return productvariantsrepo.findAll();
    }

    public List<ProductVariants> GetProductVariantsByProductId(int productId) {
        return productvariantsrepo.findByProductId(productId);
    }

    public ProductVariants updateProductVariants(int id, ProductVariants updatedProductVariants) {
        ProductVariants existingProductVariants = productvariantsrepo.findById(id).orElse(null);

        if (existingProductVariants != null) {
            existingProductVariants.setName(updatedProductVariants.getName());
            existingProductVariants.setSku(updatedProductVariants.getSku());
            existingProductVariants.setPrice(updatedProductVariants.getPrice());
            existingProductVariants.setProductId(updatedProductVariants.getProductId());
            existingProductVariants.setQuantity(updatedProductVariants.getQuantity());
            existingProductVariants.setImage_url1(updatedProductVariants.getImage_url1());
            existingProductVariants.setImage_url2(updatedProductVariants.getImage_url2());
            existingProductVariants.setImage_url3(updatedProductVariants.getImage_url3());
            return productvariantsrepo.save(existingProductVariants);
        }

        return null; // Product not found
    }

    public void deleteProductVariants(int id) {
        productvariantsrepo.deleteById(id);

    }


}
