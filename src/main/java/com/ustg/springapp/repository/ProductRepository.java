package com.ustg.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ustg.springapp.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
  
}
