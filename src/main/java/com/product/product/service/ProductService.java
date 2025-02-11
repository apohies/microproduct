package com.product.product.service;

import com.product.product.dto.ServiceResponse;
import com.product.product.model.Product;
import com.product.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ServiceResponse<List<Product>> findAll() {
        try {
            List<Product> products = repository.findAll();
            return ServiceResponse.success(products);
        } catch (Exception e) {
            return ServiceResponse.error("Error al obtener productos",
                    Collections.singletonList(e.getMessage()));
        }
    }

    public ServiceResponse<Product> findById(String id) {
        try {
            Optional<Product> product = repository.findById(id);
            if (product.isPresent()) {
                return ServiceResponse.success(product.get());
            } else {
                return ServiceResponse.error("Producto no encontrado",
                        Collections.singletonList("No existe producto con ID: " + id));
            }
        } catch (Exception e) {
            return ServiceResponse.error("Error al buscar producto",
                    Collections.singletonList(e.getMessage()));
        }
    }

    public ServiceResponse<Product> save(Product product) {
        try {
            if (product.getName() == null || product.getName().trim().isEmpty()) {
                return ServiceResponse.error("Error de validación",
                        Collections.singletonList("El nombre del producto es requerido"));
            }

            if (product.getPrice() == null || product.getPrice() <= 0) {
                return ServiceResponse.error("Error de validación",
                        Collections.singletonList("El precio debe ser mayor a 0"));
            }

            // Validación de producto existente (solo para creación, no para actualización)
            if (product.getId() == null && repository.existsByName(product.getName())) {
                return ServiceResponse.error("Error de validación",
                        Collections.singletonList("Ya existe un producto con el nombre: " + product.getName()));
            }

            Product savedProduct = repository.save(product);
            return ServiceResponse.success(savedProduct);

        } catch (Exception e) {
            return ServiceResponse.error("Error al guardar producto",
                    Collections.singletonList(e.getMessage()));
        }
    }

    public ServiceResponse<Void> deleteById(String id) {
        try {
            if (!repository.existsById(id)) {
                return ServiceResponse.error("Producto no encontrado",
                        Collections.singletonList("No existe producto con ID: " + id));
            }
            repository.deleteById(id);
            return ServiceResponse.success("Producto eliminado correctamente");
        } catch (Exception e) {
            return ServiceResponse.error("Error al eliminar producto",
                    Collections.singletonList(e.getMessage()));
        }
    }
}