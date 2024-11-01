package com.ustg.springapp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ustg.springapp.model.Product;
import com.ustg.springapp.service.ProductService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class ProductController {

  @Autowired 
  private ProductService productService;

  @PostMapping("/api/product")
  public ResponseEntity<?> addProduct(@RequestBody Product product){
    try {
      Product savedProduct = productService.addProduct(product);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid product details");
    }
  }

  @GetMapping("/api/product")
  public ResponseEntity<?> getAllProduct(){
    return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
  }

  @GetMapping("/api/product/{productId}")
  public ResponseEntity<?> getProduct(@PathVariable int productId){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(productId));
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
  }

  @DeleteMapping("/api/product/{productId}")
  public ResponseEntity<?> deleteProduct(@PathVariable int productId){
    try {
      productService.deleteProduct(productId);
      return ResponseEntity.status(HttpStatus.OK).body("Product deleted successfully");
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
  }

  @PutMapping("/api/product/{productId}")
  public ResponseEntity<?> updateProduct(@PathVariable int productId, @RequestBody Product product){
    try {
      return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(productId, product));
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
  }

}
