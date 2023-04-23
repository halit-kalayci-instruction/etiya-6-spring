package com.etiya.ecommercedemo.entities.concrete;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Annotations
//@Getter
//@Setter
@Data
@AllArgsConstructor // => tüm propertyler ile doldurulmuş bir constructor oluşturur
@NoArgsConstructor // => 0 parametreli bir concs. oluşturur.
@Table(name="categories")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
