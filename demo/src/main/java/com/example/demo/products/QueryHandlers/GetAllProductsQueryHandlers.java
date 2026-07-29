package com.example.demo.products.QueryHandlers;

import com.example.demo.products.ProductRepository;
import com.example.demo.products.Query;
import com.example.demo.products.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductsQueryHandlers implements Query<Void, List<Products>> {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public ResponseEntity<List<Products>> execute(Void input) {


        return ResponseEntity.ok(productRepository.findAll());
    }

}
