package com.example.demo.products.QueryHandlers;

import com.example.demo.products.ProductRepository;
import com.example.demo.products.Query;
import com.example.demo.products.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service //This will implement our query
public class GetProductQueryHandlers implements Query <Integer, Products> {

    //Just like the last query were going to need to inject our repository

    @Autowired
    private ProductRepository productRepository;


    @Override //Our Integer name was input I changed it to id
    public ResponseEntity<Products> execute(Integer id) {
        Optional<Products> Products  = productRepository.findById(id);
        //Optional works as lets go to the repository lets go and try to find id, and
        //if we find it we can just return product but if there's nothing in there
        //you don't want it to return null
        if (Products.isEmpty()){
            //throw an exception
            throw new RuntimeException("Product not found");
        }
        //if Products is not empty am going to use a return

        return ResponseEntity.ok(Products.get());

    }
}
