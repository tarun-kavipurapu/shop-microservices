package com.test.microservices.product_service.controllers;

import com.test.microservices.product_service.dto.ApiResponse;
import com.test.microservices.product_service.dto.ProductRequest;
import com.test.microservices.product_service.models.Product;
import com.test.microservices.product_service.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ProductController {
	@Autowired
	private final ProductService productService;
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<String>>createProduct(@RequestBody ProductRequest productRequest){
		String responseMessage=productService.createProduct(productRequest);
		ApiResponse<String>response = new ApiResponse<>(true,responseMessage,null);
		return ResponseEntity.ok().body(response);
    }
	@GetMapping("/products")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ApiResponse<List<Product>>>getProducts(){
		List<Product>products = productService.getProducts();
		ApiResponse<List<Product>>response = new ApiResponse<>(true,"All Products Fetched",products);
		 return ResponseEntity.ok(response);
	}
}
