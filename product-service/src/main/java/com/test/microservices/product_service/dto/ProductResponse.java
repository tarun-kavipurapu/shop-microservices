package com.test.microservices.product_service.dto;

import java.math.BigDecimal;

public record ProductResponse(String title, String description, String name, BigDecimal price,String Id){
}
