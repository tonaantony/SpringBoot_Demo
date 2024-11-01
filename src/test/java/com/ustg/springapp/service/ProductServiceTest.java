package com.ustg.springapp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.ustg.springapp.repository.ProductRepository;

public class ProductServiceTest {
  @Mock
  ProductRepository productRepository;

  @InjectMocks
  ProductService productService;

  @Test
  void testAddProduct() {

  }
}
