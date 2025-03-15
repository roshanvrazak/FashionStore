package com.fashionstore.service;
import java.util.List;

import com.fashionstore.entity.Category;
import com.fashionstore.entity.Product;

public interface ProductService {

    Product getProductById(Long productId);

    List<Product> getAllProducts();

    List<Product> getProductsByCategory(Category category);

    Product createProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(Long productId);
}
