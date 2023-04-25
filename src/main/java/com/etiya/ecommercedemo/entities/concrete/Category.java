package com.etiya.ecommercedemo.entities.concrete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("category")
    private List<Product> products;
}
