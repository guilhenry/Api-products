package com.gestao_produto.service;

import com.gestao_produto.model.Product;
import com.gestao_produto.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> productList (){
        return productRepository.findAll();
    }

    public Optional<Product> productForId(Long id){
        return productRepository.findById(id);
    }

    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public void deletProduct(Long id){
         productRepository.deleteById(id);
    }
}
