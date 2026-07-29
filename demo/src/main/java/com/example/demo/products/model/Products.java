package com.example.demo.products.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
@Table(name="product")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Integer id;

    @Column(name ="name")
    private String name;

    @Column(name ="description")
    private String description;

    @Column(name = "price")
    private Integer price;

    @Column(name ="quantity")
    private Integer  quantity;

}
