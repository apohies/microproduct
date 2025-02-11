package com.product.product.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryHttpClient {
    private final RestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/api/inventory/";

    @Autowired
    public InventoryHttpClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void deleteInventoryByProductId(String productId) {
        restTemplate.delete(BASE_URL + productId);
    }
}

