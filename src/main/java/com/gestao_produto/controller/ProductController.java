package com.gestao_produto.controller;


import com.gestao_produto.model.Product;
import com.gestao_produto.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Api/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listProducts(){
        List<Product> products = productService.productList();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> creatProduct(Product product){
        Product productAdd = productService.addProduct(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> killProduct(Long id){
        if(!productService.productForId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        productService.deletProduct(id);
        return ResponseEntity.noContent().build();
    }
}
