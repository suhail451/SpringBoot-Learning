package com.codewithkeertan.store.Controller;

import com.codewithkeertan.store.entities.Product;
import com.codewithkeertan.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductsController {

    private final ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProdcuts(){
        return productRepository.findAll();
    }



}

