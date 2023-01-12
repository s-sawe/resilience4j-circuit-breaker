package org.example.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class CategoryDTO {

    private int id;
    private String name;
    private String category;
    private String color;
    private String price;
}
