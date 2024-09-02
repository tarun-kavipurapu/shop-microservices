package com.test.microservices.product_service.services;

import com.test.microservices.product_service.dto.ProductRequest;
import com.test.microservices.product_service.models.Product;
import com.test.microservices.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public String createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                              .price(productRequest.price())
                              .name(productRequest.name())
                              .description(productRequest.description())
                              .build();



        productRepository.save(product);


        log.info("Sucessfully Created the Product");

        //sanitize or check the inputs or check for this later
        return "Sucessfully Created the Product";
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }


}
