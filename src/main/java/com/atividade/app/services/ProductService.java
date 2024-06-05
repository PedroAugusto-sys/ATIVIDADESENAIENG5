package com.atividade.app.services;

import com.atividade.app.models.Product;
import com.atividade.app.repositories.ProductRepository;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product findById(Long id) {
        Optional<Product> obj = this.productRepository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    }

    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product save(Product objDTO) {
        return this.productRepository.save(objDTO);
    }

    public void delete(Long id){
        this.productRepository.deleteById(id);
    }
}
