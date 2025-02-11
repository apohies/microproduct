package com.product.product.controller;

import com.product.product.client.InventoryHttpClient;
import com.product.product.dto.ServiceResponse;
import com.product.product.model.Product;
import com.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {

    @Autowired
    private ProductService service;

    @Autowired
    private InventoryHttpClient client;


    @GetMapping
    public ResponseEntity<ServiceResponse<List<Product>>> getAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResponse<Product>> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServiceResponse<Product>> createProduct(@RequestBody Product product) {
        return ResponseEntity.ok(service.save(product));
    }



    @DeleteMapping("{id}")
    public ResponseEntity<ServiceResponse<Void>> deleteProduct(@PathVariable String id) {


         client.deleteInventoryByProductId(id);

         return  ResponseEntity.ok(service.deleteById(id));
    }
}