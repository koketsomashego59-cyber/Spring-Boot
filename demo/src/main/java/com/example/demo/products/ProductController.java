package com.example.demo.products;

import com.example.demo.products.QueryHandlers.GetAllProductsQueryHandlers;
import com.example.demo.products.QueryHandlers.GetProductQueryHandlers;
import com.example.demo.products.QueryHandlers.commandhandlers.CreateProductCommandHandler;
import com.example.demo.products.model.Products;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/products")

public class ProductController {
    //Create, Read, Update, Delete
    //Post, Get, Put, Delete

    @Autowired
    private ProductRepository  productRepository;

    @Autowired
    public GetAllProductsQueryHandlers getAllProductsQueryHandlers;

    //We use autowire to link another class into main
    @Autowired
    private GetProductQueryHandlers getProductQueryHandlers;

    @Autowired
    private CreateProductCommandHandler createProductCommandHandler;

    @GetMapping
    public ResponseEntity<List<Products>> getProducts() {
        return getAllProductsQueryHandlers.execute(null);


    }

    @GetMapping("/{id}")//
    public ResponseEntity<Products> getProductById(@PathVariable Integer id) {

        return getProductQueryHandlers.execute(id);

    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody Products product) {
        return createProductCommandHandler.execute(product);

    }


    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Products product) {
    product.setId(id);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id) {
        Products product = productRepository.findById(id).get();
        productRepository.delete(product);
        return ResponseEntity.ok().build();
    }
}
