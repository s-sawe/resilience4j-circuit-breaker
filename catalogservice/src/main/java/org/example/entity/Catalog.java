package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATALOG_TBL")
@Data @AllArgsConstructor @NoArgsConstructor
public class Catalog {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String category;
    private String color;
    private double price;
    public Catalog(String name, String category, String color, Double price) {
        this.name = name;
        this.category = category;
        this.color = color;
        this.price = price;
    }
}
