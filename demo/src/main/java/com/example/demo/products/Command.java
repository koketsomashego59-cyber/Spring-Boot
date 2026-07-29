package com.example.demo.products;

//E is going to sand for entity
//T is a jenaric in Java

import org.springframework.http.ResponseEntity;

public interface Command <E, T>{
 ResponseEntity<T> execute(E entity );

}
