package org.example.controller;


import org.example.entity.Catalog;
import org.example.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/")
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;

    @PostConstruct
    public void catalogTable(){
        catalogRepository.saveAll(Stream.of(
                new Catalog("mobile", "electronics", "white", 2000.0),
                new Catalog("T-shirt", "clothes", "black", 900.0),
                new Catalog("Laptop", "electronics", "grey", 90000.0)

        ). collect(Collectors.toList()));
    }
    @GetMapping("all")
    public List<Catalog> getCatalog(){
        return catalogRepository.findAll();
    }
    @GetMapping("{category}")
    public List<Catalog> getOrdersByCategory(@PathVariable String category){
        return catalogRepository.findByCategory(category);
    }
}
