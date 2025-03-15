package com.fashionstore.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fashionstore.entity.Product;
import com.fashionstore.reporsitory.ProductRepository;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testGetProductById() {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product();
		mockProduct.setProductId(productId);
        when(productRepository.findById(productId)).thenReturn(Optional.of(mockProduct));

        // Act
        Product result = productService.getProductById(productId);

        // Assert
        assertNotNull(result);
        assertEquals(productId, result.getProductId());
    }
}
