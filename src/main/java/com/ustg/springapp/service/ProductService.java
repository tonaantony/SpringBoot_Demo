package com.ustg.springapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ustg.springapp.model.Product;
import com.ustg.springapp.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {

  @Autowired ProductRepository productRepository;

  
  public Product addProduct(Product product){
    return productRepository.save(product);
  }

  public List<Product> getAllProducts(){
    return productRepository.findAll();
  }

  public Product getProduct(int productId){
    Optional<Product> optional =  productRepository.findById(productId);
    if(optional.isPresent()){
      return optional.get();
    }
    else{
      throw new EntityNotFoundException();
    }
  }

  public void deleteProduct(int productId){
    if(productRepository.existsById(productId)){
      productRepository.deleteById(productId);
    }
    else{
      throw new EntityNotFoundException();
    }
  }

  public Product updateProduct(int productId, Product product){
    if(productRepository.existsById(productId)){
      product.setProductId(productId);
      return productRepository.save(product);
    }
    else{
      throw new EntityNotFoundException();
    }
  }
  
}
