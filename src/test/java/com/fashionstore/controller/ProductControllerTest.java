package com.fashionstore.controller;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fashionstore.entity.Product;
import com.fashionstore.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void testGetProductById() throws Exception {
        // Arrange
        Long productId = 1L;
        Product mockProduct = new Product();
        mockProduct.setProductId(productId);
        when(productService.getProductById(productId)).thenReturn(mockProduct);

        // Act and Assert
        mockMvc.perform(get("/products/{id}", productId))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.id", is(productId.intValue())));
    }
}
