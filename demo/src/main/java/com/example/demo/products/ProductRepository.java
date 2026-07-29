package com.example.demo.products;

import com.example.demo.products.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Products, Integer> {
}
