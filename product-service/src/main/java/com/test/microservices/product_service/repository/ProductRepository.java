package com.test.microservices.product_service.repository;

import com.test.microservices.product_service.models.Product;
import lombok.Builder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
