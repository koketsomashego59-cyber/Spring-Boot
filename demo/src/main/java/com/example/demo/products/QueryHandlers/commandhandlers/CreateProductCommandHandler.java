package com.example.demo.products.QueryHandlers.commandhandlers;

import com.example.demo.products.Command;
import com.example.demo.products.ProductRepository;
import com.example.demo.products.model.Products;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductCommandHandler implements Command<Products, ResponseEntity> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public ResponseEntity execute(Products product) {

        //name

        if(StringUtils.isEmpty(product.getName())){
            //throw exception
            throw new RuntimeException("Product name cannot be empty");

        }

        //description

        if (StringUtils.isEmpty(product.getDescription())){
            //throw exception
            throw new RuntimeException("Product description cannot be empty");
        }


        //price

        if (product.getPrice() <=0.0){
            //throw exception
            throw new RuntimeException("Price is invalid");
        }


        //quantity
        if (product.getQuantity() <=0){
            //throw exception
            throw new RuntimeException("Quantity is invalid");
        }









        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
