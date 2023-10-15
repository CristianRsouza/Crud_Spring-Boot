package com.example.crud.crud.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.crud.domain.product.Product;
import com.example.crud.crud.domain.product.RepositoryProduct;
import com.example.crud.crud.domain.product.RequestProduct;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private RepositoryProduct repository;
    @GetMapping
    public ResponseEntity getAllProducts() {
        var allProducts = repository.findAll();
        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity registeryProducts(@RequestBody @Validated RequestProduct data) {
        
        Product newProduct = new Product(data);
        repository.save(newProduct);
        return ResponseEntity.ok().build();   
    }
}
