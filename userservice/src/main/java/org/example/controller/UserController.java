package org.example.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/")
public class UserController {

    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    private static final String BASE_URL = "http://localhost:8080/api/v1/all";

    public static final String USER_SERVICE="user-service-breaker";

    @GetMapping("show-orders") //for all orders, use endpoint = http://localhost:8081/api/v1/show-orders?category
    @CircuitBreaker(name = USER_SERVICE, fallbackMethod = "getAllAvailableProducts")
    public List<CategoryDTO> showOrders(@RequestParam("category") String category){
        String url = category == null ? BASE_URL : BASE_URL + "/" + category;
        return restTemplate.getForObject(url, ArrayList.class);
    }

    public List<CategoryDTO> getAllAvailableProducts(Exception e){
        return Stream.of(new CategoryDTO(1,"TV", "electronics", "grey", 2000.0)
        ).collect(Collectors.toList());

    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
