package com.test.microservices.product_service.dto;


import java.math.BigDecimal;


public record ProductRequest(String title, String description, String name, BigDecimal price){
}
