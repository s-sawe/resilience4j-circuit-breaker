package org.example.controller;

import org.example.entity.CategoryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/api/v1/all";

    @GetMapping("show-orders") //for all orders, use endpoint = http://localhost:8081/api/v1/show-orders?category
    public List<CategoryDTO> showOrders(@RequestParam("category") String category){
        String url = category == null ? BASE_URL : BASE_URL + "/" + category;
        return restTemplate.getForObject(url, ArrayList.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
